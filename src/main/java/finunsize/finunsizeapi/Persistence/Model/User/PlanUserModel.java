package finunsize.finunsizeapi.Persistence.Model.User;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name="PlanoUsuario")
public class PlanUserModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id_plano_usuario;

    @Column(nullable = false, length = 50)
    private String nome;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private int telefone;

    @Column(nullable = false, length = 9)
    private int cep;

    @Column(nullable = false, columnDefinition = "BOOLEAN")
    private boolean plano_padrao;

}
