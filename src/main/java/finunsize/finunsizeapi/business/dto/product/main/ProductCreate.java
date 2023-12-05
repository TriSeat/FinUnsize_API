package finunsize.finunsizeapi.business.dto.product.main;

import finunsize.finunsizeapi.business.dto.product.InfoProduct.InfoProductCreate;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.time.LocalDate;

public record ProductCreate (
        @NotBlank String cod_barras,
        @NotBlank @Size(max = 50) String nome,
        @Min(value = 1, message = "O valor mínimo permitido é 1") int quantidade,
        InfoProductCreate informacoes,
        String fornecedor,
        LocalDate validade,
        @NotBlank @Size(max = 150) String descricao,
        BigDecimal varejo,
        BigDecimal atacado,
        String url_image
){}
