package finunsize.finunsizeapi.business.dto.user.plan;

import finunsize.finunsizeapi.persistence.model.user.UserModel;

import java.util.UUID;

public record UserResponse(
        UUID Id,
        String login,
        String nome,
        String email,
        int telefone,
        int cep,
        String cnpj,
        String url_image
) {
    public UserResponse(UserModel user) {
        this(user.getId(), user.getLogin(), user.getNome(), user.getEmail(), user.getTelefone(), user.getCep(), user.getCompany().getCnpj(), user.getUrl_image());
    }
}