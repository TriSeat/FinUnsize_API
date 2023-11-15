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
    @Column(name = "id_fornecedor")
    private UUID idFornecedor;

    @Column(nullable = false, length = 90)
    private String nome;

    @OneToOne (optional = false)
    @JoinColumn(name = "id_endereco")
    private AddressModel id_endereco;

    @Column(nullable = false, length = 150)
    private String descricao;

    private String url_image;

    @Column(nullable = false, length = 18, columnDefinition = "CHAR(18)")
    private String cnpj;
}