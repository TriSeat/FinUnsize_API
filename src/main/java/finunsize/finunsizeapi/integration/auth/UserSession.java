package finunsize.finunsizeapi.integration.auth;

import finunsize.finunsizeapi.business.configuration.handler.user.ContextNullException;
import finunsize.finunsizeapi.persistence.model.user.UserModel;
import finunsize.finunsizeapi.persistence.repository.user.CompanyRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserSession {

    private final CompanyRepository companyRepository;

    public UserSession(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    private Authentication getAuthentication() {
        SecurityContext context = SecurityContextHolder.getContext();
        if (context != null) {
            return context.getAuthentication();
        }
        return null;
    }

    public String getCurrentUsername()  {
        Authentication auth = getAuthentication();
        return auth.getName();
    }

    public String getCurrentLogin() {
        Authentication auth = getAuthentication();
        UserModel userModel = (UserModel) auth.getPrincipal();
        return userModel.getLogin();
    }

    public String getSessionCnpj() {
        Authentication auth = getAuthentication();

        if (auth.getPrincipal() instanceof UserModel) {
            UserModel planUserModel = (UserModel) auth.getPrincipal();
            return planUserModel.getCompany().getCnpj();
        }

        return null;
    }

    public UUID getUUID() {
        Authentication auth = getAuthentication();

        if (auth.getPrincipal() instanceof UserModel) {
                UserModel userModel = (UserModel) auth.getPrincipal();
                return userModel.getId();
        }
        return null;
    }
}
