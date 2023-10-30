package finunsize.finunsizeapi.business.dto.user.local;

import finunsize.finunsizeapi.persistence.model.user.Role;
import finunsize.finunsizeapi.persistence.model.user.local.LocalUserModel;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.UUID;

public record LocalUserResponse(
        UUID Id,
        String nome,
        String email,
        Role Role,
        String url_image
) {
    public  LocalUserResponse (LocalUserModel user) {
        this(user.getId_usuario(), user.getNome(), user.getEmail(), user.getRole(), user.getUrl_image());
    }
}
