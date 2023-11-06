package finunsize.finunsizeapi.persistence.model.purchase;

import finunsize.finunsizeapi.persistence.model.payment.PaymentModel;
import finunsize.finunsizeapi.persistence.model.product.SupplierModel;
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
@Table(name="Compra")
public class PurchaseModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id_compra;

    @Column(nullable = false, length = 50)
    private String nome;

    @ManyToOne
    @JoinColumn(name = "id_pagamento", nullable = false)
    private PaymentModel id_pagamento;

    @Column(nullable = false)
    private BigDecimal preco_total;

    @DateTimeFormat(pattern = "dd-MM-yyy HH:mm:ss")
    @Column(nullable = false)
    private LocalDateTime data;

    @ManyToOne (optional = false)
    @JoinColumn(name = "id_fornecedor")
    private SupplierModel id_fornecedor;

    @OneToMany(mappedBy = "purchase", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PurchaseItemModel> purchase_item = new ArrayList<>();

    @Column(length = 18, columnDefinition = "CHAR(18)")
    private String cnpj;
}
