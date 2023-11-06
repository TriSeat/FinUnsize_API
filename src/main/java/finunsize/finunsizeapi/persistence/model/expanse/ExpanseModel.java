package finunsize.finunsizeapi.persistence.model.expanse;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Table(name="Despesa")
@NoArgsConstructor
public class ExpanseModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id_despesa;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(nullable = false)
    private BigDecimal valor;

    private LocalDate data_vencimento;


    private LocalDate data_pagamento;

    @ManyToOne (optional = false)
    @JoinColumn(name = "id")
    private TypeExpanseModel tipo_despesa;

    @Column(length = 150)
    private String observacao;

    @Column(nullable = false)
    private boolean aberto;

    @Column(nullable = false, length = 18, columnDefinition = "CHAR(18)")
    private String cnpj;

}
