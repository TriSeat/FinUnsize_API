package finunsize.finunsizeapi.persistence.repository.user;

import finunsize.finunsizeapi.persistence.model.user.company.CompanyModel;
import finunsize.finunsizeapi.persistence.model.user.plan.PlanUserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface PlanUserRepository extends JpaRepository <PlanUserModel, UUID> {
    UserDetails findByNome(String name);
    boolean existsByNome(String name);
    boolean existsByEmail(String email);

    @Query(value = "SELECT * FROM plano_usuario p WHERE p.cnpj = :cnpj", nativeQuery = true)
    Optional<PlanUserModel> findByCnpj(String cnpj);

    Optional<PlanUserModel> findById(UUID id);


    boolean existsByNomeAndCnpj_CnpjNot(String nome, String cnpj);;

    boolean existsByEmailAndCnpj_CnpjNot(String email, String cnpj);
}
