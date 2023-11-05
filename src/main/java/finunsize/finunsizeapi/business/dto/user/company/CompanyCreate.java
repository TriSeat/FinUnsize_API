package finunsize.finunsizeapi.business.dto.user.company;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public record CompanyCreate(
        @Pattern(regexp = "^\\d{2}\\.\\d{3}\\.\\d{3}/\\d{4}-\\d{2}$", message = "Formato de CNPJ inválido, o formato deve ser 00.000.000/0000-00")
        @NotBlank
        String cnpj,
        @NotBlank @Size(max = 100) String nome,
        @NotBlank @Size(max = 100) String slogan,
        @NotBlank @Size(max = 60) String segmento,
        int cep,
        BigDecimal renda_media,
        BigDecimal balanco_atual,
        BigDecimal despesa_media,
        @NotBlank @Size(max = 100) String razao,
        String url_image
) {}

