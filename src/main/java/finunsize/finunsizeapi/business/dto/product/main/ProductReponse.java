package finunsize.finunsizeapi.business.dto.product.main;

import finunsize.finunsizeapi.business.dto.product.InfoProduct.InfoProductResponse;
import finunsize.finunsizeapi.persistence.model.product.ProductModel;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.time.LocalDate;
public record ProductReponse(
        String cod_barras,
        String nome,
        int quantidade,
        InfoProductResponse informacoes,
        String fornecedor,
        LocalDate validade,
        String descricao,
        BigDecimal varejo,
        BigDecimal atacado,
        LocalDate data_cadastro,
        String url_image
) {
    public ProductReponse(ProductModel product) {
        this(product.getCodBarras(), product.getNome(), product.getQuantidade(),
            new InfoProductResponse(
                    product.getInformacoes().getIdItemProduto(),
                    product.getInformacoes().getMarca(),
                    product.getInformacoes().getCategoria(),
                    product.getInformacoes().getTipo()
            ),
                product.getFornecedor() != null ? product.getFornecedor().getNome() : null, product.getValidade(), product.getDescricao(), product.getVarejo(),
                product.getAtacado(), product.getData_cadastro(), product.getUrl_image()
        );
    }
}