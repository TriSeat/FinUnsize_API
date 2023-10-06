package finunsize.finunsizeapi.Persistence.Model.Product;

import finunsize.finunsizeapi.Persistence.Model.Product.InfoProductModel;
import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name="Produto")
public class ProductModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id_produto;

    @Column(nullable = false, length = 50)
    private String nome;

    @Column(nullable = false)
    private int quantidade;

    @ManyToOne
    @JoinColumn(name = "id_item_produto", nullable = false)
    private InfoProductModel informacoes;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd-MM-yyy")
    @Column(nullable = false)
    private Date validade;

    @Column(nullable = false, length = 150)
    private String descricao;

    @Column(nullable = false)
    private BigDecimal varejo;

    @Column(nullable = false)
    private BigDecimal atacado;

}
