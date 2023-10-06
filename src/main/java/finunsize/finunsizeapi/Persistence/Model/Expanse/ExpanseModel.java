package finunsize.finunsizeapi.Persistence.Model.Expanse;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name="Despesa")
public class ExpanseModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id_despesa;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(nullable = false)
    private BigDecimal valor;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd-MM-yyy")
    private Date data_vencimento;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd-MM-yyy")
    private Date data_pagamento;

    @ManyToOne
    @JoinColumn(name = "id", nullable = false)
    private TypeExpanseModel tipo_despesa;

    @Column(length = 150)
    private String observacao;

    @Column(nullable = false)
    private boolean aberto;

}
