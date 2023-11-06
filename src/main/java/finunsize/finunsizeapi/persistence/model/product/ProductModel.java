package finunsize.finunsizeapi.persistence.model.product;

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

    @Column(nullable = false)
    private LocalDate validade;

    @Column(nullable = false, length = 150)
    private String descricao;

    @Column(nullable = false)
    private BigDecimal varejo;

    @Column(nullable = false)
    private BigDecimal atacado;

    @Column(nullable = false)
    private LocalDate data_cadastro;

    private String url_image;

    @Column(nullable = false, length = 18, columnDefinition = "CHAR(18)")
    private String cnpj;
}
