package finunsize.finunsizeapi.integration.auth;

import finunsize.finunsizeapi.business.configuration.handler.user.ContextNullException;
import finunsize.finunsizeapi.persistence.model.user.UserModel;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.CompletionException;

@Service
public class UserSession {

    private Authentication getAuthentication() throws ContextNullException {
        SecurityContext context = SecurityContextHolder.getContext();
        if (context != null) {
            return context.getAuthentication();
        }
        throw new ContextNullException("The Context is null");
    }

    public String getCurrentUsername() throws ContextNullException {
        Authentication auth = getAuthentication();
        return auth.getName();
    }

    public String getCurrentLogin() throws ContextNullException {
        Authentication auth = getAuthentication();
        UserModel userModel = (UserModel) auth.getPrincipal();
        return userModel.getLogin();
    }

    public String getSessionCnpj() throws ContextNullException {
        Authentication auth = getAuthentication();

        if (auth.getPrincipal() instanceof UserModel) {
            UserModel planUserModel = (UserModel) auth.getPrincipal();
            return planUserModel.getCompany().getCnpj();
        }

        return "CNPJ not founded";
    }

    public UUID getUUID() throws ContextNullException {
        Authentication auth = getAuthentication();

        if (auth.getPrincipal() instanceof UserModel) {
                UserModel userModel = (UserModel) auth.getPrincipal();
                return userModel.getId();
        }
        return null;
    }
}
