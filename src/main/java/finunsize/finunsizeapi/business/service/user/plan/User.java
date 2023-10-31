package finunsize.finunsizeapi.business.service.user.plan;

import finunsize.finunsizeapi.business.configuration.handler.user.EntityAlreadyExistsException;
import finunsize.finunsizeapi.business.configuration.utils.ValidationRule;
import finunsize.finunsizeapi.business.dto.user.plan.PlanUserResponse;
import finunsize.finunsizeapi.business.dto.user.plan.PlanUserSign;
import finunsize.finunsizeapi.business.dto.user.plan.PlanUserUpdate;
import finunsize.finunsizeapi.persistence.model.user.Role;
import finunsize.finunsizeapi.persistence.model.user.plan.PlanUserModel;
import finunsize.finunsizeapi.persistence.repository.user.CompanyRepository;
import finunsize.finunsizeapi.persistence.repository.user.PlanUserRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
public class PlanUser implements UserDetailsService, PlanUserService {

    private final PlanUserRepository planUserRepository;
    private final CompanyRepository companyRepository;
    PlanUserModel planUserModel;

    @Autowired
    public PlanUser(PlanUserRepository planUserRepository, CompanyRepository companyRepository) {
        this.planUserRepository = planUserRepository;
        this.companyRepository = companyRepository;
        this.planUserModel = new PlanUserModel();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return planUserRepository.findByNome(username);
    }

    @Transactional
    @Override
    public PlanUserModel signUp(@Valid PlanUserSign planUserSign) {

        validUser(planUserSign.nome(), planUserSign.email());

        BeanUtils.copyProperties(planUserSign, planUserModel);

        encodePassword(planUserSign.password());
        insertCompany(planUserSign.cnpj());
        planUserModel.setRole(Role.valueOf("ADMIN_PLAN"));

        return planUserRepository.save(planUserModel);
    }

    @Override
    public PlanUserResponse findUser(UUID id) {
        var user = planUserRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Usuário contendo este cnpj não foi encontrado: " + id));
        return new PlanUserResponse(user);
    }

    @Transactional
    @Override
    public PlanUserModel updateUser(String cnpj, @Valid PlanUserUpdate planUserUpdate) {

        var existingUser = planUserRepository.findByCnpj(cnpj)
                .orElseThrow(() -> new EntityNotFoundException("Usuário contendo este CNPJ não foi encontrado: " + cnpj));

        validCredentials(planUserUpdate.nome(), planUserUpdate.email(), cnpj);

        BeanUtils.copyProperties(planUserUpdate, existingUser, "cnpj");

        if (!planUserUpdate.password().isEmpty()) {
            String encrypt = new BCryptPasswordEncoder().encode(planUserUpdate.password());
            existingUser.setPassword(encrypt);
        }

        return planUserRepository.save(existingUser);
    }

    @Transactional
    @Override
    public void deleteUser(String cnpj) {
        PlanUserModel existingUser = planUserRepository.findByCnpj(cnpj)
                .orElseThrow(() -> new EntityNotFoundException("Usuário contendo este cnpj não foi encontrado: " + cnpj));
        planUserRepository.delete(existingUser);
    }

    private void validUser(String name, String email) {
        if (planUserRepository.existsByNome(name) || planUserRepository.existsByEmail(email)) {
            throw new EntityAlreadyExistsException("Nome ou email já existem", name + email);
        }
    }

    private void validCredentials(String name, String email, String cnpj) {
        List<ValidationRule> validationRules = Arrays.asList(
                () -> planUserRepository.existsByNomeAndCnpj_CnpjNot(name, cnpj),
                () -> planUserRepository.existsByEmailAndCnpj_CnpjNot(email, cnpj)
        );

        boolean validationFailed = validationRules.stream().anyMatch(rule -> rule.check());

        if (validationFailed) {
            throw new EntityAlreadyExistsException("Nome ou email já existem em outro usuário", name  + email);
        }
    }


    private void encodePassword(String password) {
        String encrypt = new BCryptPasswordEncoder().encode(password);
        planUserModel.setPassword(encrypt);
    }

    private void insertCompany(String cnpj) {
        var company = companyRepository.findByCnpj(cnpj);
        planUserModel.setCnpj(company);
    }
}
