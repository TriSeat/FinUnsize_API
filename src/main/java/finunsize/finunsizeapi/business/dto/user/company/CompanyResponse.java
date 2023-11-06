package finunsize.finunsizeapi.business.dto.user.company;

import finunsize.finunsizeapi.persistence.model.user.CompanyModel;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.antlr.v4.runtime.misc.NotNull;

import java.math.BigDecimal;

public record CompanyResponse(
        String cnpj,
        String nome,
        String slogan,
        String segmento,
        int cep,
        BigDecimal renda_media,
        BigDecimal balanco_atual,
        BigDecimal despesa_media,
        String razao,
        String url_image
) {
    public CompanyResponse(CompanyModel company) {
        this(company.getCnpj(), company.getNome(), company.getSlogan(), company.getSegmento(), company.getCep(),
                company.getRenda_media(), company.getBalanco_atual(), company.getDespesa_media(), company.getRazao(), company.getUrl_image());
    }
}
