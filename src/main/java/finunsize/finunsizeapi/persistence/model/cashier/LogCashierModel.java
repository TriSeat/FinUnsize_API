package finunsize.finunsizeapi.persistence.model.cashier;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="LogCaixa")
public class LogCashierModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id_log_caixa;

    @ManyToOne
    @JoinColumn(name = "id_caixa", nullable = false)
    private CashierModel id_caixa;

    private LocalDateTime data_funcionamento;

    @Column(nullable = false)
    private BigDecimal valor_inicial;

    @Column(nullable = false)
    private BigDecimal valor_final;

    @DateTimeFormat(pattern = "HH:mm:ss")
    private LocalDateTime abertura;

    @DateTimeFormat(pattern = "HH:mm:ss")
    private LocalDateTime fechamento;

    @Column(nullable = false, length = 18, columnDefinition = "CHAR(18)")
    private String cnpj;

}
