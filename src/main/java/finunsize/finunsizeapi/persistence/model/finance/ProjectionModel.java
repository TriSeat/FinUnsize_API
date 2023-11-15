package finunsize.finunsizeapi.persistence.model.finance;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
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
    @Column(name = "id_projecao")
    private UUID idProjecao;

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

    @Column(nullable = false)
    private LocalDate data;

    @Column(nullable = false, length = 18, columnDefinition = "CHAR(18)")
    private String cnpj;

}
