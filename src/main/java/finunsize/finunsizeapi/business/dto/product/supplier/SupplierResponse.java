package finunsize.finunsizeapi.business.dto.product.supplier;

import finunsize.finunsizeapi.business.dto.address.AddressResponse;
import finunsize.finunsizeapi.persistence.model.product.SupplierModel;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record SupplierResponse(
        java.util.UUID idFornecedor,
        String nome,
        AddressResponse endereco,
        String descricao,
        String url_image
) {
    public SupplierResponse(SupplierModel supplier) {
        this(supplier.getIdFornecedor(), supplier.getNome(),
                new AddressResponse(
                        supplier.getId_endereco().getId_logradouro(),
                        supplier.getId_endereco().getCep(),
                        supplier.getId_endereco().getRua(),
                        supplier.getId_endereco().getNumero(),
                        supplier.getId_endereco().getComplemento(),
                        supplier.getId_endereco().getReferencia(),
                        supplier.getId_endereco().getCidade()
                ),
                supplier.getDescricao(), supplier.getUrl_image());
    }
}
