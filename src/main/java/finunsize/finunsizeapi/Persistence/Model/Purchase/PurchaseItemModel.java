package finunsize.finunsizeapi.Persistence.Model.Purchase;

import finunsize.finunsizeapi.Persistence.Model.Product.ProductModel;
import finunsize.finunsizeapi.Persistence.Model.Product.SupplierModel;
import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name="ItemCompra")
public class PurchaseItemModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id_item_compra;

    @ManyToOne
    @JoinColumn(name = "id_compra", nullable = false)
    private PurchaseModel id_compra;

    @ManyToOne
    @JoinColumn(name = "id_fornecedor", nullable = false)
    private SupplierModel id_fornecedor;

    @ManyToOne
    @JoinColumn(name = "id_produto", nullable = false)
    private ProductModel id_produto;

    @Column(nullable = false)
    private BigDecimal valor_unitario;

    @Column(nullable = false)
    private int quantidade;


}
