package finunsize.finunsizeapi.business.service.user.main;

import finunsize.finunsizeapi.business.configuration.handler.user.ContextNullException;
import finunsize.finunsizeapi.business.dto.user.main.UserResponse;
import finunsize.finunsizeapi.business.dto.user.main.UserSign;
import finunsize.finunsizeapi.business.dto.user.main.UserUpdate;
import finunsize.finunsizeapi.persistence.model.user.UserModel;

import java.util.List;
import java.util.UUID;

public interface UserService {
    UserModel signUp(UserSign planUserSign);
    UserModel updateUser(UUID id, UserUpdate planUserUpdate);
    void deleteUser(UUID id);
    UserResponse findLogin() throws ContextNullException;
    UserResponse findUser(String username) throws ContextNullException;
    List<UserResponse> listUser() throws ContextNullException;
}
