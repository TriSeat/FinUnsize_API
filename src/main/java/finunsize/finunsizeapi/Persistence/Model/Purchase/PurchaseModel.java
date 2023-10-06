package finunsize.finunsizeapi.Persistence.Model.Purchase;

import finunsize.finunsizeapi.Persistence.Model.Payment.PaymentModel;
import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.UUID;

@Entity
@Table(name="Compra")
public class PurchaseModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id_compra;

    @ManyToOne
    @JoinColumn(name = "id_pagamento", nullable = false)
    private PaymentModel id_pagamento;

    @Column(nullable = false)
    private BigDecimal preco_total;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd-MM-yyy")
    @Column(nullable = false)
    private Date data;

}
