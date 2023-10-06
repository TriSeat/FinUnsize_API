package finunsize.finunsizeapi.Persistence.Model.Employeer;

import finunsize.finunsizeapi.Persistence.Model.Cashier.CashierModel;
import finunsize.finunsizeapi.Persistence.Model.Employeer.EmployeeModel;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name="FuncionarioCaixa")
public class EmployeeCashierModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_funcionario_caixa;

    @ManyToOne
    @JoinColumn(name = "id_caixa", nullable = false)
    private CashierModel id_caixa;

    @ManyToOne
    @JoinColumn(name = "id_funcionario", nullable = false)
    private EmployeeModel id_funcionario;
}
