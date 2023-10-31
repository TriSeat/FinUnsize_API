package finunsize.finunsizeapi.persistence.model.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="Empresa")
public class CompanyModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(length = 14, columnDefinition = "CHAR(14)")
    private String cnpj;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(nullable = false, length = 100)
    private String slogan;

    @Column(nullable = false, length = 60)
    private String segmento;

    @Column(nullable = false, columnDefinition = "CHAR(8)")
    private int cep;

    @Column(nullable = false)
    private BigDecimal renda_media;

    @Column(nullable = false)
    private BigDecimal balanco_atual;

    @Column(nullable = false)
    private BigDecimal despesa_media;

    @Column(nullable = false, length = 100)
    private String razao_social;

    private String url_image;
}
