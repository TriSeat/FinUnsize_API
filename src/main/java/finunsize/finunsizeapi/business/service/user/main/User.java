package finunsize.finunsizeapi.business.service.user.main;

import finunsize.finunsizeapi.business.configuration.handler.user.ContextNullException;
import finunsize.finunsizeapi.business.configuration.handler.user.EntityAlreadyExistsException;
import finunsize.finunsizeapi.business.dto.user.main.UserResponse;
import finunsize.finunsizeapi.business.dto.user.main.UserSign;
import finunsize.finunsizeapi.business.dto.user.main.UserUpdate;
import finunsize.finunsizeapi.integration.auth.UserSession;
import finunsize.finunsizeapi.persistence.model.user.UserModel;
import finunsize.finunsizeapi.persistence.repository.user.CompanyRepository;
import finunsize.finunsizeapi.persistence.repository.user.UserRepository;
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

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class User implements UserDetailsService, UserService {

    private final UserRepository userRepository;
    private final CompanyRepository companyRepository;
    private final UserSession userSession;

    @Autowired
    public User(UserRepository userRepository, CompanyRepository companyRepository, UserSession userSession) {
        this.userRepository = userRepository;
        this.companyRepository = companyRepository;
        this.userSession = userSession;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByLogin(username);
    }

    @Transactional
    @Override
    public UserModel signUp(@Valid UserSign userSign) {

        UserModel userModel = new UserModel();

        validUser(userSign.login(), userSign.email());

        BeanUtils.copyProperties(userSign, userModel, "id");

        encodePassword(userModel, userSign.password());
        insertCompany(userModel, userSign.cnpj());
        return userRepository.save(userModel);
    }

    @Override
    public UserResponse findLogin() throws ContextNullException {
        String login = userSession.getCurrentLogin();
        var user = userRepository.findByLogin(login);
        return new UserResponse((UserModel) user);
    }

    @Override
    public UserResponse findUser(String username) throws ContextNullException {
        var cnpj = userSession.getSessionCnpj();
        var user = userRepository.findByNomeAndCnpj_Cnpj(username, cnpj)
                .orElseThrow(() -> new EntityNotFoundException("Usuário foi encontrado"));
        return new UserResponse(user);
    }

    @Override
    public List<UserResponse> listUser() throws ContextNullException {
        String cnpj = userSession.getSessionCnpj();
        List<UserModel> users = userRepository.findAllByCnpj_Cnpj(cnpj);
        List<UserResponse> response = users
                .stream()
                .map(UserResponse::new)
                .collect(Collectors.toList());
        return response;
    }

    @Transactional
    @Override
    public UserModel updateUser(UUID id, @Valid UserUpdate planUserUpdate) {

        var existingUser = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Usuário contendo tal ID não foi encontrado: " + id));

        BeanUtils.copyProperties(planUserUpdate, existingUser, "id");

        if (!planUserUpdate.password().isEmpty()) {
            String encrypt = new BCryptPasswordEncoder().encode(planUserUpdate.password());
            existingUser.setPassword(encrypt);
        }

        return userRepository.save(existingUser);
    }

    @Transactional
    @Override
    public void deleteUser(UUID id) {
        UserModel existingUser = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Usuário contendo este id não foi encontrado: " + id));
        userRepository.delete(existingUser);
    }

    private void validUser(String login, String email) {
        if (userRepository.existsByLogin(login) || userRepository.existsByEmail(email)) {
            throw new EntityAlreadyExistsException("Login ou email já existem", login +" " + email);
        }
    }


    private void encodePassword(UserModel userModel, String password) {
        String encrypt = new BCryptPasswordEncoder().encode(password);
        userModel.setPassword(encrypt);
    }

    private void insertCompany(UserModel userModel, String cnpj) {
        var company = companyRepository.findByCnpj(cnpj);
        userModel.setCnpj(company);
    }
}
