package finunsize.finunsizeapi.Persistence.Model.Product;

import finunsize.finunsizeapi.Persistence.Model.Andress.AnddressModel;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name="Fornecedor")
public class SupplierModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id_fornecedor;

    @Column(nullable = false)
    private String nome;

    @OneToOne
    @JoinColumn(name = "id_endereco", nullable = false)
    private AnddressModel id_endereco;

    @Column(nullable = false, length = 150)
    private String descricao;
}
