package finunsize.finunsizeapi.Persistence.Model.Expanse;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name="ItemDespesa")
public class TypeExpanseModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id_despesa;

    @Column(nullable = false)
    private String nome;

    @Column(length = 150)
    private String descicao;
}
