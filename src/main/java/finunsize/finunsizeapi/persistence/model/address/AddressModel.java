package finunsize.finunsizeapi.persistence.model.address;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="Logradouro")
public class AddressModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id_logradouro;

    @Column(length = 9)
    private int cep;

    @Column(nullable = false)
    private String rua;

    @Column(nullable = false)
    private String numero;

    @Column(length = 10)
    private String complemento;

    @Column(length = 150)
    private String referencia;

    @Column(nullable = false, length = 100)
    private String cidade;
}
