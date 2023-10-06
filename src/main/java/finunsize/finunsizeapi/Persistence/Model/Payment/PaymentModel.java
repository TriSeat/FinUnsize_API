package finunsize.finunsizeapi.Persistence.Model.Payment;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name="Pagamento")
public class PaymentModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id_pagamento;

    @Column(nullable = false, length = 70)
    private String nome;

}
