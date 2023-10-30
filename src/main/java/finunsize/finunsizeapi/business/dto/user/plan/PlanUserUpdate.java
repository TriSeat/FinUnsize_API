package finunsize.finunsizeapi.business.dto.user.plan;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record PlanUserUpdate (
        @NotBlank @Size(max = 50) String nome,
        @NotBlank String password,
        @NotBlank @Size(max = 50) String email,
        int telefone,
        int cep,
        String url_image
) {}
