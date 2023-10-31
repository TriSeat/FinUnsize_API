package finunsize.finunsizeapi.persistence.model.purchase;

import finunsize.finunsizeapi.persistence.model.product.ProductModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="ItemCompra")
public class PurchaseItemModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id_item_compra;

    @ManyToOne (optional = false)
    @JoinColumn(name = "cod_barras")
    private ProductModel cod_barras;

    @Column(nullable = false)
    private BigDecimal valor_unitario;

    @Column(nullable = false)
    private int quantidade;

    @ManyToOne (optional = false)
    @JoinColumn(name = "id_compra")
    private PurchaseModel purchase;

}
