package finunsize.finunsizeapi.Persistence.Model.Cashier;


import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.sql.Time;

@Entity
@Table(name="Caixa")
public class CashierModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_caixa;
    @Column(nullable = false, length = 50)
    private String nome;
    @Column(nullable = false, length = 10)
    private String status;

}
