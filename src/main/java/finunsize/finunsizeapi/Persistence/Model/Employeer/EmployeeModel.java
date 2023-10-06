package finunsize.finunsizeapi.Persistence.Model.Employeer;

import finunsize.finunsizeapi.Persistence.Model.Andress.AnddressModel;
import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name="funcionario")
public class EmployeeModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_funcionario;

    @Column(nullable = false, length = 100)
    private String nome;

    @ManyToOne
    @JoinColumn(name = "id_cargo", nullable = false)
    private OfficeModel cargo;

    @Column(nullable = false)
    private String turno;

    @Column(nullable = false)
    private int telefone;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd-MM-yyy")
    @Column(nullable = false)
    private Date admissao;

    @OneToOne
    @JoinColumn(name = "id_endereco", nullable = false)
    private AnddressModel id_endereco;

    @Column(nullable = false)
    private BigDecimal salario;

    @Column(length = 150)
    private String observacao;

    private boolean demitido;
}
