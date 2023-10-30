package finunsize.finunsizeapi.business.dto.product;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record ProductReponse(
        @NotBlank String cod_barras,
        @NotBlank @Size(max = 50) String nome,
        int quantidade,
        @NotBlank @DateTimeFormat(pattern = "dd-MM-yyy") LocalDateTime validade,
        @NotBlank @Size(max = 150) String descricao,
        BigDecimal varejo,
        BigDecimal atacado,
        @NotBlank @DateTimeFormat(pattern = "dd-MM-yyy") LocalDateTime data_cadastro
) {}
