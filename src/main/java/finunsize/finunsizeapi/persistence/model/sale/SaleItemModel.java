package finunsize.finunsizeapi.persistence.model.sale;

import finunsize.finunsizeapi.persistence.model.product.ProductModel;
import finunsize.finunsizeapi.persistence.model.user.company.CompanyModel;
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
@Table(name="ItemVenda")
public class SaleItemModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id_item_venda;

    @ManyToOne (optional = false)
    @JoinColumn(name = "id_venda")
    private SaleModel venda;

    @ManyToOne (optional = false)
    @JoinColumn(name = "cod_barras")
    private ProductModel cod_barras;

    @Column(nullable = false)
    private BigDecimal valor_unitario;

    @Column(nullable = false)
    private int quantidade;

}
