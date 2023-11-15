package finunsize.finunsizeapi.business.dto.expanse.main;

import finunsize.finunsizeapi.persistence.model.expanse.ExpanseModel;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

public record ExpanseResponse(
        UUID id_depesa,
        String nome,
        BigDecimal valor,
        LocalDate data_vencimento,
        LocalDate data_pagamento,
        String tipo_despesa,
        String oservacao,
        boolean aberto
) {
    public ExpanseResponse(ExpanseModel expanse) {
        this(expanse.getIdDespesa(),
                expanse.getNome(),
                expanse.getValor(),
                expanse.getData_vencimento(),
                expanse.getData_pagamento(),
                expanse.getTipo_despesa().getNome(),
                expanse.getObservacao(),
                expanse.isAberto());
    }
}
