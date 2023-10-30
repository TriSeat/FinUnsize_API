package finunsize.finunsizeapi.business.service.user.local;

import finunsize.finunsizeapi.business.configuration.handler.user.ContextNullException;
import finunsize.finunsizeapi.business.dto.user.local.LocalUserResponse;
import finunsize.finunsizeapi.business.dto.user.local.LocalUserSign;
import finunsize.finunsizeapi.business.dto.user.local.LocalUserUpdate;
import finunsize.finunsizeapi.persistence.model.user.local.LocalUserModel;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

import java.util.List;
import java.util.UUID;
public interface LocalUserService {
    LocalUserResponse findUser(UUID id);
    LocalUserModel signup(LocalUserSign localUserSign, String cnpj);

    List<LocalUserResponse> listUser() throws ContextNullException;

   LocalUserModel updateUser(UUID id, @Valid LocalUserUpdate localUserUpdate);
    void deleteUser(UUID id);
}
