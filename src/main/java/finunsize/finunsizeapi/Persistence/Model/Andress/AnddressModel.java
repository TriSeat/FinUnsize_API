package finunsize.finunsizeapi.Persistence.Model.Andress;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name="Logradouro")
public class AnddressModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id_endereco;
    @Column(nullable = false, length = 9)
    private int cep;
    @Column(nullable = false)
    private String rua;
    @Column(nullable = false)
    private String numero;
    private String complemento;
    @Column(length = 150)
    private String referencia;
    @Column(nullable = false, length = 100)
    private String cidade;

}
