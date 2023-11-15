package finunsize.finunsizeapi.persistence.model.employee;

import finunsize.finunsizeapi.persistence.model.address.AddressModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
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
    @Column(name = "id_funcionario")
    private int idFuncionario;

    @Column(nullable = false, unique = true, columnDefinition = "CHAR(14)")
    private String cpf;

    @Column(nullable = false, length = 100)
    private String nome;

    @ManyToOne (optional = false)
    @JoinColumn(name = "id_cargo")
    private OfficeModel cargo;

    @Column(nullable = false, length = 20)
    private String turno;

    @Column(nullable = false)
    private int telefone;

    @Column(nullable = false)
    private LocalDate admissao;

    @OneToOne (optional = false)
    @JoinColumn(name = "id_logradouro")
    private AddressModel id_logradouro;

    @Column(nullable = false)
    private BigDecimal salario;

    @Column(length = 150)
    private String observacao;

    private boolean demitido;

    private String url_image;

    @Column(nullable = false, length = 18, columnDefinition = "CHAR(18)")
    private String cnpj;
}
