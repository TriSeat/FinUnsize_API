package finunsize.finunsizeapi.persistence.repository.expanse;

import finunsize.finunsizeapi.persistence.model.expanse.ExpanseModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ExpanseRepository extends JpaRepository <ExpanseModel, UUID> {
    Optional<ExpanseModel> findByNomeAndCnpj(String name, String cnpj);
    Optional<ExpanseModel> findByIdDespesaAndCnpj(UUID id, String cnpj);
    List<ExpanseModel> findAllByCnpj(String cnpj);
    boolean existsByNomeAndCnpj(String name, String cnpj);
    boolean existsByNomeAndIdDespesaNot(String name, UUID id);
}
