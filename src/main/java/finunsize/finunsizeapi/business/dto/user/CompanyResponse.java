package finunsize.finunsizeapi.business.dto.user;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CompanyResponse(
        @NotBlank @Size(max = 14) long CNPJ,
        @NotBlank @Size(max = 100) String nome,
        @NotBlank @Size(max = 100) String slogan,
        @Size(max = 8) int cep,
        @NotBlank @Size(max = 100) String razao_social
) {}
