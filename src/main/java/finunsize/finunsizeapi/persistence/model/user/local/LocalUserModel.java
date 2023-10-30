package finunsize.finunsizeapi.persistence.model.user.local;

import finunsize.finunsizeapi.persistence.model.user.Role;
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
@Table(name="Usuario")
public class LocalUserModel implements UserDetails, Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id_usuario;

    @Column(nullable = false, length = 100, unique = true)
    private String nome;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private Role role;

    private String url_image;

    @Column(length = 14, columnDefinition = "CHAR(14)")
    private String cnpj;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (this.role == Role.MANAGER) return List.of(new SimpleGrantedAuthority("MANAGER"), new SimpleGrantedAuthority("CAIXA"));
        return List.of(new SimpleGrantedAuthority("CAIXA"));
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
}
