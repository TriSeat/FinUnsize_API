package finunsize.finunsizeapi.business.dto.user.main;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UserUpdate(
        @NotBlank @Size(max = 50) String nome,
        @NotBlank @Size(max = 70) String login,
        @NotBlank String password,
        @Email @NotBlank @Size(max = 50) String email,
        int telefone,
        int cep,
        String url_image
) {}
