package finunsize.finunsizeapi.business.dto.purchase;

import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;

public record PurchaseItemResponse(
       @NotBlank String cod_barras,
       BigDecimal valor_unitario,
       int quantidade
) {}
