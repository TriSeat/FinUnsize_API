package finunsize.finunsizeapi.business.dto.product.InfoProduct;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record InfoProductCreate (
        @NotBlank @Size(max = 90) String marca,
        @NotBlank @Size(max = 90) String categoria,
        @NotBlank @Size(max = 90) String tipo
) {}
