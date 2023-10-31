package finunsize.finunsizeapi.persistence.repository.user;

import finunsize.finunsizeapi.persistence.model.user.CompanyModel;
import finunsize.finunsizeapi.persistence.model.user.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository <UserModel, UUID> {
    List<UserModel> findAllByCnpj_Cnpj(String cnpj);
    UserDetails findByLogin(String login);
    Optional<UserModel> findByNomeAndCnpj_Cnpj(String login, String cnpj);
    boolean existsByNome(String name);
    boolean existsByEmail(String email);

    @Query(value = "SELECT * FROM plano_usuario p WHERE p.cnpj = :cnpj", nativeQuery = true)
    Optional<UserModel> findByCnpj(String cnpj);

    Optional<UserModel> findById(UUID id);

    boolean existsByNomeAndCnpj_CnpjNot(String nome, String cnpj);;

    boolean existsByEmailAndCnpj_CnpjNot(String email, String cnpj);

    boolean existsByLogin(String login);
}
