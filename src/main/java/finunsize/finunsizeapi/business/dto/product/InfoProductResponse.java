package finunsize.finunsizeapi.business.dto.product;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record InfoProductResponse(
   @NotBlank @Size(max = 90) String marca,
   @NotBlank @Size(max = 90) String categoria,
   @NotBlank @Size(max = 90) String tipo
) {}
