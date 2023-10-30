package finunsize.finunsizeapi.business.dto.sale;

import finunsize.finunsizeapi.persistence.model.sale.SaleItemModel;
import jakarta.validation.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public record SaleResponse(
        @NotBlank int id_caixa,
        BigDecimal valor_total,
        int quantidade,
        @NotBlank String pagamento,
        @NotBlank @DateTimeFormat(pattern = "dd-MM-yyy") LocalDateTime data,
        @NotBlank List<SaleItemModel> saleItem
) {}
