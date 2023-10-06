package finunsize.finunsizeapi.Persistence.Model.User;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name="Usuario")
public class LocalUserModel {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id_usuario;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private boolean admin;
}
