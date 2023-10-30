package finunsize.finunsizeapi.business.dto.product;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record SupplierResponse(
        @NotBlank @Size(max = 90) String nome,
        @NotBlank String endereco,
        @NotBlank @Size(max = 150) String descricao
) {}
