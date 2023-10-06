package finunsize.finunsizeapi.Persistence.Model.Sale;

import finunsize.finunsizeapi.Persistence.Model.Product.ProductModel;
import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name="ItemVenda")
public class SaleItemModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id_item_venda;

    @ManyToOne
    @JoinColumn(name = "id_venda", nullable = false)
    private SaleModel id_venda;

    @ManyToOne
    @JoinColumn(name = "id_produto", nullable = false)
    private ProductModel id_produto;

    @Column(nullable = false)
    private BigDecimal valor_unitario;

    @Column(nullable = false)
    private int quantidade;

}
