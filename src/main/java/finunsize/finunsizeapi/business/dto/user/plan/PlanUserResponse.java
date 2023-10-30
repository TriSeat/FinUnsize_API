package finunsize.finunsizeapi.business.dto.user.plan;

import finunsize.finunsizeapi.persistence.model.user.plan.PlanUserModel;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.UUID;

public record PlanUserResponse(
        UUID Id,
        String nome,
        String email,
        int telefone,
        int cep,
        boolean plano_padrao,
        String cnpj,
        String url_image
) {
    public PlanUserResponse(PlanUserModel user) {
        this(user.getId(), user.getNome(), user.getEmail(), user.getTelefone(), user.getCep(), user.isPlano_padrao(), user.getCompany().getCnpj(), user.getUrl_image());
    }
}