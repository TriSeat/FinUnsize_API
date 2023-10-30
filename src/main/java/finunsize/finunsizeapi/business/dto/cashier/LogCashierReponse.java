package finunsize.finunsizeapi.business.dto.cashier;

import jakarta.validation.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record LogCashierReponse(
        int id_caixa,
        @NotBlank @DateTimeFormat(pattern = "dd-MM-yyy") LocalDateTime data_funcionamento,
        BigDecimal valor_inicial,
        BigDecimal valor_final,
        @NotBlank @DateTimeFormat(pattern = "HH:mm:ss") LocalDateTime abertura,
        @NotBlank @DateTimeFormat(pattern = "HH:mm:ss") LocalDateTime fechamento
) { }
