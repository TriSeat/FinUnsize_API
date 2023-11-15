package finunsize.finunsizeapi.business.dto.expanse.main;

import finunsize.finunsizeapi.business.dto.expanse.type.TypeExpanseCreate;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.time.LocalDate;

public record ExpanseCreate (
        @NotBlank @Size(max = 100) String nome,
        BigDecimal valor,
        LocalDate data_vencimento,
        LocalDate data_pagamento,
        @NotBlank String tipo_despesa,
        @NotBlank @Size(max=150) String observacao,
        boolean aberto
) {}