package finunsize.finunsizeapi.Persistence.Model.Sale;

import finunsize.finunsizeapi.Persistence.Model.Cashier.CashierModel;
import finunsize.finunsizeapi.Persistence.Model.Payment.PaymentModel;
import finunsize.finunsizeapi.Persistence.Model.Product.ProductModel;
import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name="Venda")
public class SaleModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id_venda;

    @ManyToOne
    @JoinColumn(name = "id_produto", nullable = false)
    private ProductModel id_produto;

    @ManyToOne
    @JoinColumn(name = "id_caixa", nullable = false)
    private CashierModel id_caixa;

    @Column(nullable = false)
    private BigDecimal valor_total;

    @Column(nullable = false)
    private int quantidade;

    @ManyToOne
    @JoinColumn(name = "id_pagamento", nullable = false)
    private PaymentModel pagamento;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd-MM-yyy")
    @Column(nullable = false)
    private Date data;
}
