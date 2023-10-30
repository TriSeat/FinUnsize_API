package finunsize.finunsizeapi.persistence.model.finance;

import finunsize.finunsizeapi.persistence.model.user.company.CompanyModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
    private int numero_venda;

    @Column(nullable = false)
    private BigDecimal valor_despesa;

    @Column(nullable = false, length = 150)
    private String descricao;

    @DateTimeFormat(pattern = "dd-MM-yyy")
    @Column(nullable = false)
    private LocalDateTime data;

    @Column(length = 14, columnDefinition = "CHAR(14)")
    private String cnpj;

}
