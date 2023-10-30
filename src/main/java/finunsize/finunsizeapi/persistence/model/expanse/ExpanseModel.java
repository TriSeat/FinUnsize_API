package finunsize.finunsizeapi.persistence.model.expanse;

import finunsize.finunsizeapi.persistence.model.user.company.CompanyModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
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

    @DateTimeFormat(pattern = "dd-MM-yyy")
    private LocalDateTime data_vencimento;

    @DateTimeFormat(pattern = "dd-MM-yyy")
    private LocalDateTime data_pagamento;

    @ManyToOne (optional = false)
    @JoinColumn(name = "id")
    private TypeExpanseModel tipo_despesa;

    @Column(length = 150)
    private String observacao;

    @Column(nullable = false)
    private boolean aberto;

    @Column(length = 14, columnDefinition = "CHAR(14)")
    private String cnpj;

}
