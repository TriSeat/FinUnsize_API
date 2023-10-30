package finunsize.finunsizeapi.business.dto.finance;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record FinanceReponse(
        BigDecimal saldo_liquido,
        BigDecimal saldo_bruto,
        int numero_venda,
        BigDecimal valor_despesa,
        @NotBlank @Size(max = 150) String descricao,
        @NotBlank @DateTimeFormat(pattern = "dd-MM-yyy") LocalDateTime data
) {}
