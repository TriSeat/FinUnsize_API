package finunsize.finunsizeapi.business.dto.user.local;

import finunsize.finunsizeapi.persistence.model.user.Role;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record LocalUserSign (
        @NotBlank @Size(max = 50) String nome,
        @NotBlank String password,
        @NotBlank @Size(max = 50) String email,
        Role Role,
        String url_image
) {}
