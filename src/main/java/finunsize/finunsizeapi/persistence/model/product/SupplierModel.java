package finunsize.finunsizeapi.persistence.model.product;

import finunsize.finunsizeapi.persistence.model.address.AddressModel;
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
@Table(name="Fornecedor")
public class SupplierModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id_fornecedor;

    @Column(nullable = false, length = 90)
    private String nome;

    @OneToOne (optional = false)
    @JoinColumn(name = "id_endereco")
    private AddressModel id_endereco;

    @Column(nullable = false, length = 150)
    private String descricao;

    private String url_image;

    @Column(length = 14, columnDefinition = "CHAR(14)")
    private String cnpj;
}
