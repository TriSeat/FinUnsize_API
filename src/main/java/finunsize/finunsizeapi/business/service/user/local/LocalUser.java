package finunsize.finunsizeapi.business.service.user.local;

import finunsize.finunsizeapi.business.configuration.handler.user.ContextNullException;
import finunsize.finunsizeapi.business.configuration.handler.user.EntityAlreadyExistsException;
import finunsize.finunsizeapi.business.dto.user.local.LocalUserResponse;
import finunsize.finunsizeapi.business.dto.user.local.LocalUserSign;
import finunsize.finunsizeapi.business.dto.user.local.LocalUserUpdate;
import finunsize.finunsizeapi.integration.auth.UserSession;
import finunsize.finunsizeapi.persistence.model.user.local.LocalUserModel;
import finunsize.finunsizeapi.persistence.repository.user.LocalUserRepository;
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
public class LocalUser implements UserDetailsService, LocalUserService {

    private final LocalUserRepository localUserRepository;
    private final UserSession userSession;
    LocalUserModel localUserModel;

    @Autowired
    public LocalUser(LocalUserRepository localUserRepository, UserSession userSession) {
        this.localUserRepository = localUserRepository;
        this.userSession = userSession;
        this.localUserModel = new LocalUserModel();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return localUserRepository.findByNome(username);
    }

    @Override
    public LocalUserResponse findUser(UUID id) {
        var user = localUserRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Usuário não encontrado"));
        return new LocalUserResponse(user);
    }

    @Transactional
    @Override
    public LocalUserModel signup(@Valid LocalUserSign localUserSign, String cnpj) {

        validUser(localUserSign.nome(), localUserSign.email());
        BeanUtils.copyProperties(localUserSign, localUserModel);

        encodePassword(localUserSign.password());
        insertCompany(cnpj);

        return localUserRepository.save(localUserModel);
    }


    @Override
    public List<LocalUserResponse> listUser() throws ContextNullException {

        String cnpj = userSession.getSessionCnpj();

        List<LocalUserModel> users = localUserRepository.findAllByCnpj(cnpj);

        List<LocalUserResponse> userResponses = users
                .stream()
                .map(LocalUserResponse::new)
                .collect(Collectors.toList());

        return userResponses;
    }

    @Transactional
    @Override
    public LocalUserModel updateUser(UUID id, @Valid LocalUserUpdate localUserUpdate) {

        var existingUser = localUserRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado"));

        validUser(localUserUpdate.nome(), localUserUpdate.email());

        BeanUtils.copyProperties(localUserUpdate, existingUser, "id_usuario");

        if (!localUserUpdate.password().isEmpty()) {
            String encrypt = new BCryptPasswordEncoder().encode(localUserUpdate.password());
            existingUser.setPassword(encrypt);
        }

        return localUserRepository.save(existingUser);
    }

    @Transactional
    @Override
    public void deleteUser(UUID id) {
        var existingUser = localUserRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Usuário não encontrado"));
        localUserRepository.delete(existingUser);
    }

    private void validUser(String name, String email) {
        if(localUserRepository.existsByNome(name) || localUserRepository.existsByEmail(email)) {
            throw new EntityAlreadyExistsException("Nome ou email já existem", name + email);
        }
    }

    private void encodePassword(String password) {
        String encrypt = new BCryptPasswordEncoder().encode(password);
        localUserModel.setPassword(encrypt);
    }

    private void insertCompany(String cnpj) {
        localUserModel.setCnpj(cnpj);
    }
}
