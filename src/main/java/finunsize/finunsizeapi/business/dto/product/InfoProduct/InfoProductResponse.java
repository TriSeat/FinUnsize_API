package finunsize.finunsizeapi.business.dto.product.InfoProduct;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.UUID;

public record InfoProductResponse(
        UUID idItemProduto,
        String marca,
        String categoria,
        String tipo
) {}