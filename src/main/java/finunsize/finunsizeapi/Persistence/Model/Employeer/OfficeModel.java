package finunsize.finunsizeapi.Persistence.Model.Employeer;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name="Cargo")
public class OfficeModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id_cargo;

    @Column(nullable = false, length = 50)
    private String nome;

    @Column(length = 150)
    private String descricao;

}
