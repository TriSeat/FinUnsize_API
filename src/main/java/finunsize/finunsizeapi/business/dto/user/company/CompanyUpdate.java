package finunsize.finunsizeapi.business.dto.user.company;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public record CompanyUpdate(
        @NotBlank @Size(max = 100) String nome,
        @NotBlank @Size(max = 100) String slogan,
        @NotBlank @Size(max = 60) String segmento,
        @NotNull Integer cep,
        @NotNull BigDecimal renda_media,
        @NotNull BigDecimal balanco_atual,
        @NotNull BigDecimal despesa_media,
        @NotBlank @Size(max = 100) String razao_social,
        String url_image
) {}