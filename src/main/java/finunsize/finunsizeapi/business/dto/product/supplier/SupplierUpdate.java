package finunsize.finunsizeapi.business.dto.product.supplier;

import finunsize.finunsizeapi.business.dto.address.AddressUpdate;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record SupplierUpdate(
        @NotBlank @Size(max = 90) String nome,
        AddressUpdate endereco,
        @NotBlank @Size(max = 150) String descricao,
        String url_image
) {}
