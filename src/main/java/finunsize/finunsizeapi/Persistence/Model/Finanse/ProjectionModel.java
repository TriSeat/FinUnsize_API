package finunsize.finunsizeapi.Persistence.Model.Finanse;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.UUID;

@Entity
@Table(name="Projecao")
public class ProjectionModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id_projecao;

    @Column(nullable = false)
    private BigDecimal saldo_liquido;

    @Column(nullable = false)
    private BigDecimal saldo_bruto;

    @Column(nullable = false)
    private BigDecimal numero_venda;

    @Column(nullable = false)
    private BigDecimal valor_despesa;

    @Column(nullable = false, length = 150)
    private String descricao;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd-MM-yyy")
    @Column(nullable = false)
    private Date data;

}
