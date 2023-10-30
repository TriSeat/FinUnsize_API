package finunsize.finunsizeapi.persistence.model.expanse;

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

    @Column(length = 14, columnDefinition = "CHAR(14)")
    private String cnpj;
}
