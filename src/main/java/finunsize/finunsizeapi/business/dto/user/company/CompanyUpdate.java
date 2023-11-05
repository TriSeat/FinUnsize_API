package finunsize.finunsizeapi.business.dto.user.company;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public record CompanyUpdate(
        @NotBlank @Size(max = 100) String nome,
        @NotBlank @Size(max = 100) String slogan,
        @NotBlank @Size(max = 60) String segmento,
        int cep,
        BigDecimal renda_media,
        BigDecimal balanco_atual,
        BigDecimal despesa_media,
        @NotBlank @Size(max = 100) String razao_social,
        String url_image
) {}