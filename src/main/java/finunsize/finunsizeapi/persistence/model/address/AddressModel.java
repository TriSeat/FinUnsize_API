package finunsize.finunsizeapi.persistence.model.address;

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
@Table(name="Logradouro")
public class AddressModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(length = 9)
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

    @Column(length = 14, columnDefinition = "CHAR(14)")
    private String cnpj;
}
