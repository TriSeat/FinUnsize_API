package finunsize.finunsizeapi.business.dto.user.main;

import finunsize.finunsizeapi.persistence.model.user.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record UserSign(
        @NotBlank @Size(max = 50) String nome,
        @NotBlank @Size(max = 70) String login,
        @NotBlank String password,
        @Email @NotBlank @Size(max = 50) String email,
        int telefone,
        int cep,
        boolean plano_padrao,
        Role role,
        @Pattern(regexp = "^\\d{2}\\.\\d{3}\\.\\d{3}/\\d{4}-\\d{2}$", message = "Formato de CNPJ inválido, o formato deve ser 00.000.000/0000-00")
        @NotBlank
        String cnpj,
        String url_image
) {}