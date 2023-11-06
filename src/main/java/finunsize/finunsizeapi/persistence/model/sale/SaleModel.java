package finunsize.finunsizeapi.persistence.model.sale;

import finunsize.finunsizeapi.persistence.model.cashier.CashierModel;
import finunsize.finunsizeapi.persistence.model.payment.PaymentModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="Venda")
public class SaleModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id_venda;

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

    @DateTimeFormat(pattern = "dd-MM-yyy HH:mm:ss")
    @Column(nullable = false)
    private LocalDateTime data;

    @OneToMany(mappedBy = "venda", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SaleItemModel>  saleItemModels = new ArrayList<>();

    @Column(length = 18, columnDefinition = "CHAR(18)")
    private String cnpj;
}
