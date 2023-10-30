package finunsize.finunsizeapi.business.dto.user.local;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record LocalUserUpdate (
        @NotBlank @Size(max = 100) String nome,
        @NotBlank String password,
        @NotBlank @Size(max = 50) String email,
        @NotBlank String Role,
        String url_image
) {}
