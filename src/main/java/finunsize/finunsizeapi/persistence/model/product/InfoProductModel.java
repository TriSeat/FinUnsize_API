package finunsize.finunsizeapi.persistence.model.product;

import finunsize.finunsizeapi.persistence.model.user.company.CompanyModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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

    @Column(length = 14, columnDefinition = "CHAR(14)")
    private String cnpj;
}
