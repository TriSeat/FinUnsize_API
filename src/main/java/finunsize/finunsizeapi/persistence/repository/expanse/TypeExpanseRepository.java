package finunsize.finunsizeapi.persistence.repository.expanse;

import finunsize.finunsizeapi.business.dto.expanse.type.TypeExpanseResponse;
import finunsize.finunsizeapi.persistence.model.expanse.TypeExpanseModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface TypeExpanseRepository extends JpaRepository <TypeExpanseModel, UUID> {
    Optional<TypeExpanseModel> findIdByNomeAndCnpj(String name, String cnpj);
    Optional<TypeExpanseModel> findByIdDespesaAndCnpj(UUID id, String cnpj);
    boolean existsByNomeAndIdDespesaNot(String name, UUID id);
    Optional<TypeExpanseModel> findByNomeAndCnpj(String name, String cnpj);
    List<TypeExpanseModel> findByCnpj(String cnpj);
    boolean existsByNomeAndCnpj(String name, String cnpj);
}