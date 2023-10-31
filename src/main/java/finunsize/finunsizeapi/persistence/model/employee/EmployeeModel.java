package finunsize.finunsizeapi.persistence.model.employee;

import finunsize.finunsizeapi.persistence.model.address.AddressModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="funcionario")
public class EmployeeModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_funcionario;

    @Column(nullable = false, length = 100)
    private String nome;

    @ManyToOne (optional = false)
    @JoinColumn(name = "id_cargo")
    private OfficeModel cargo;

    @Column(nullable = false, length = 20)
    private String turno;

    @Column(nullable = false)
    private int telefone;

    @DateTimeFormat(pattern = "dd-MM-yyy")
    @Column(nullable = false)
    private LocalDateTime admissao;

    @OneToOne (optional = false)
    @JoinColumn(name = "id_endereco")
    private AddressModel id_endereco;

    @Column(nullable = false)
    private BigDecimal salario;

    @Column(length = 150)
    private String observacao;

    @Column(columnDefinition = "VARCHAR(8) DEFAULT 'admitido'")
    private String status;

    @Column(nullable = false)
    private String url_image;

    @Column(length = 14, columnDefinition = "CHAR(14)")
    private String cnpj;
}
