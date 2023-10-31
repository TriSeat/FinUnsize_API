package finunsize.finunsizeapi.business.dto.user.main;

import finunsize.finunsizeapi.persistence.model.user.Role;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UserSign(
        @NotBlank @Size(max = 50) String nome,
        @NotBlank @Size(max = 70) String login,
        @NotBlank String password,
        @NotBlank @Size(max = 50) String email,
        int telefone,
        int cep,
        boolean plano_padrao,
        Role role,
        @NotBlank String cnpj,
        String url_image
) {}