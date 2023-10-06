package finunsize.finunsizeapi.Persistence.Model.Product;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name="ItemProduto")
public class InfoProductModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id_item_produto;

    @Column(nullable = false, length = 90)
    private String marca;

    @Column(nullable = false, length = 90)
    private String categoria;

    @Column(nullable = false, length = 90)
    private String tipo;

}
