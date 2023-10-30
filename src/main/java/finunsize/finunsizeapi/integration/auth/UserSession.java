package finunsize.finunsizeapi.integration.auth;

import finunsize.finunsizeapi.business.configuration.handler.user.ContextNullException;
import finunsize.finunsizeapi.persistence.model.user.local.LocalUserModel;
import finunsize.finunsizeapi.persistence.model.user.plan.PlanUserModel;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.UUID;

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

    public String getSessionCnpj() throws ContextNullException {
        Authentication auth = getAuthentication();

        if (auth.getPrincipal() instanceof PlanUserModel) {
            PlanUserModel planUserModel = (PlanUserModel) auth.getPrincipal();
            return planUserModel.getCompany().getCnpj();
        } else if (auth.getPrincipal() instanceof LocalUserModel) {
            LocalUserModel localUserModel = (LocalUserModel) auth.getPrincipal();
            return localUserModel.getCnpj();
        }

        return "CNPJ NULO";
    }

    public UUID getUUID() throws ContextNullException {
        Authentication auth = getAuthentication();

        if (auth.getPrincipal() instanceof PlanUserModel) {
                PlanUserModel planUserModel = (PlanUserModel) auth.getPrincipal();
                return planUserModel.getId();
        } else if (auth.getPrincipal() instanceof LocalUserModel) {
            LocalUserModel localUserModel = (LocalUserModel) auth.getPrincipal();
            return localUserModel.getId_usuario();
        }

        return null;

    }
}
