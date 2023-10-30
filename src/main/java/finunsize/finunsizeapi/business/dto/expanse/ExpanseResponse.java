package finunsize.finunsizeapi.business.dto.expanse;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record ExpanseResponse(
        @NotBlank @Size(max = 100) String nome,
        BigDecimal valor,
        @NotBlank @DateTimeFormat(pattern = "dd-MM-yyy") LocalDateTime data_vencimento,
        @NotBlank @DateTimeFormat(pattern = "dd-MM-yyy") LocalDateTime data_pagamento,
        @NotBlank String tipo_despesa,
        @NotBlank @Size(max=150) String oservacao,
        @NotBlank boolean aberto
) {}
