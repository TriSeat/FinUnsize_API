package finunsize.finunsizeapi.persistence.model.user.plan;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import finunsize.finunsizeapi.persistence.model.user.Role;
import finunsize.finunsizeapi.persistence.model.user.company.CompanyModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="PlanoUsuario")
public class PlanUserModel implements UserDetails, Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false, length = 50, unique = true)
    private String nome;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private int telefone;

    @Column(nullable = false, columnDefinition = "CHAR(8)")
    private int cep;

    @Column(nullable = false)
    private boolean plano_padrao;

    @Column(nullable = false)
    private Role role;

    private String url_image;

    @OneToOne
    @JoinColumn( name = "cnpj", referencedColumnName = "cnpj", nullable = false)
    private CompanyModel cnpj;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if(this.role == Role.MANAGER) return List.of(new SimpleGrantedAuthority("PLAN_USER"), new SimpleGrantedAuthority("MANAGER"));
        return List.of(new SimpleGrantedAuthority("MANAGER"));
    }

    @Override
    public String getUsername() {
        return this.nome;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public CompanyModel getCompany() {
        return cnpj;
    }

}
