package finunsize.finunsizeapi.business.dto.user.plan;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record PlanUserSign(
        @NotBlank @Size(max = 50) String nome,
        @NotBlank String password,
        @NotBlank @Size(max = 50) String email,
        int telefone,
        int cep,
        boolean plano_padrao,
        @NotBlank String cnpj,
        String url_image
) {}