package finunsize.finunsizeapi.business.dto.sale;

import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;

public record SaleItemResponse(
    @NotBlank String cod_barras,
    BigDecimal valor_unitario,
    int quantidade
) {}
