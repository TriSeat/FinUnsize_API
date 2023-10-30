package finunsize.finunsizeapi.persistence.model.employee;import java.util.UUID;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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

    @Column(length = 14, columnDefinition = "CHAR(14)")
    private String cnpj;

}
