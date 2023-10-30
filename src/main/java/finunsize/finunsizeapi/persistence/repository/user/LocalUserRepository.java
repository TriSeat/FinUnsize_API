package finunsize.finunsizeapi.persistence.repository.user;

import finunsize.finunsizeapi.persistence.model.user.local.LocalUserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface LocalUserRepository extends JpaRepository <LocalUserModel, UUID> {
    UserDetails findByNome(String username);
    Optional<LocalUserModel> findById(UUID id);
    List<LocalUserModel> findAllByCnpj(String cnpj);
    boolean existsByNome(String name);
    boolean existsByEmail(String email);

}
