package finunsize.finunsizeapi.business.dto.product.supplier;

import finunsize.finunsizeapi.business.dto.address.AddressCreate;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record SupplierCreate(
        @NotBlank @Size(max = 90) String nome,
        AddressCreate endereco,
        @NotBlank @Size(max = 150) String descricao,
        String url_image
) {}
