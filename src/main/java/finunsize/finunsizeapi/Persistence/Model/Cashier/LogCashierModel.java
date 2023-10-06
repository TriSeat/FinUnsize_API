package finunsize.finunsizeapi.Persistence.Model.Cashier;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Time;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name="LogCaixa")
public class LogCashierModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id_log_caixa;

    @ManyToOne
    @JoinColumn(name = "id_caixa", nullable = false)
    private CashierModel id_caixa;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd-MM-yyy")
    private Date data_funcionamento;

    @Column(nullable = false)
    private BigDecimal valor_inicial;

    @Column(nullable = false)
    private BigDecimal valor_total;

    @Temporal(TemporalType.TIME)
    @DateTimeFormat(pattern = "HH:mm:ss")
    private Time abertura;

    @Temporal(TemporalType.TIME)
    @DateTimeFormat(pattern = "HH:mm:ss")
    private Time fechamento;

}
