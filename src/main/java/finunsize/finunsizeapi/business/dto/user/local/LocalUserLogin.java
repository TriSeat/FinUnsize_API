package finunsize.finunsizeapi.business.dto.user.local;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record LocalUserLogin(
        @NotBlank @Size(max = 50) String nome,
        @NotBlank String password
) {}
