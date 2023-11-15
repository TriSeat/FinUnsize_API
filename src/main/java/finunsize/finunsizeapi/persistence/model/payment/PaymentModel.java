package finunsize.finunsizeapi.persistence.model.payment;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="Pagamento")
public class PaymentModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_pagamento")
    private UUID idPagamento;

    @Column(nullable = false, length = 70)
    private String nome;

    @Column(nullable = false, length = 14, columnDefinition = "CHAR(14)")
    private String cnpj;
}
