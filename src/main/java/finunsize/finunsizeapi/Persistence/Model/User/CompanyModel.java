package finunsize.finunsizeapi.Persistence.Model.User;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name="Empresa")
public class CompanyModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id_empresa;
    @Column(nullable = false, length = 100)
    private String nome;
    @Column(nullable = false, length = 100)
    private String slogan;
    @Column(nullable = false)
    private int CEP;
    @Column(nullable = false, length = 100)
    private String razao_social;
    @Column(nullable = false, unique = true, length = 20)
    private String CNPJ;
}
