package finunsize.finunsizeapi.persistence.model.product;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="Produto")
public class ProductModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private String cod_barras;

    @Column(nullable = false, length = 50)
    private String nome;

    @Column(nullable = false)
    private int quantidade;

    @ManyToOne (optional = false)
    @JoinColumn(name = "id_item_produto")
    private InfoProductModel informacoes;

    @DateTimeFormat(pattern = "dd-MM-yyy")
    @Column(nullable = false)
    private LocalDateTime validade;

    @Column(nullable = false, length = 150)
    private String descricao;

    @Column(nullable = false)
    private BigDecimal varejo;

    @Column(nullable = false)
    private BigDecimal atacado;

    @DateTimeFormat(pattern = "dd-MM-yyy")
    @Column(nullable = false)
    private LocalDateTime data_cadastro;

    private String url_image;

    @Column(length = 14, columnDefinition = "CHAR(14)")
    private String cnpj;
}
