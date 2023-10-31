package finunsize.finunsizeapi.persistence.model.employee;

import finunsize.finunsizeapi.persistence.model.cashier.CashierModel;
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
@Table(name="FuncionarioCaixa")
public class EmployeeCashierModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_funcionario_caixa;

    @ManyToOne (optional = false)
    @JoinColumn(name = "id_caixa")
    private CashierModel id_caixa;

    @ManyToOne (optional = false)
    @JoinColumn(name = "id_funcionario")
    private EmployeeModel id_funcionario;

    @Column(length = 14, columnDefinition = "CHAR(14)")
    private String cnpj;
}
