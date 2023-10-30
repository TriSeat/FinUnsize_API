package finunsize.finunsizeapi.business.service.user.plan;

import finunsize.finunsizeapi.business.dto.user.plan.PlanUserResponse;
import finunsize.finunsizeapi.business.dto.user.plan.PlanUserSign;
import finunsize.finunsizeapi.business.dto.user.plan.PlanUserUpdate;
import finunsize.finunsizeapi.persistence.model.user.plan.PlanUserModel;

import java.util.UUID;

public interface PlanUserService {
    PlanUserModel signUp(PlanUserSign planUserSign);
    PlanUserModel updateUser(String cnpj, PlanUserUpdate planUserUpdate);
    void deleteUser(String cnpj);
    PlanUserResponse findUser(UUID id);
}
