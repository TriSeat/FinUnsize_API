package finunsize.finunsizeapi.business.dto.user.main;

import finunsize.finunsizeapi.persistence.model.user.Role;
import finunsize.finunsizeapi.persistence.model.user.UserModel;

import java.util.UUID;

public record UserResponse(
        UUID Id,
        String nome,
        String login,
        String email,
        int telefone,
        int cep,
        Role role,
        String cnpj,
        String url_image
) {
    public UserResponse(UserModel user) {
        this(user.getId(), user.getNome(), user.getLogin(), user.getEmail(), user.getTelefone(), user.getCep(), user.getRole(), user.getCompany().getCnpj(), user.getUrl_image());
    }
}