package finunsize.finunsizeapi.persistence.model.cashier;


import finunsize.finunsizeapi.persistence.model.user.company.CompanyModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="Caixa")
public class CashierModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private int id_caixa;

    @Column(nullable = false, length = 50)
    private String nome;

    @Column(nullable = false, length = 10)
    private String status;

    @Column(length = 14, columnDefinition = "CHAR(14)")
    private String cnpj;
}
