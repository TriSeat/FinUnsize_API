package finunsize.finunsizeapi.persistence.repository.employee;

import finunsize.finunsizeapi.persistence.model.employee.OfficeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface OfficeRepository extends JpaRepository <OfficeModel, UUID> {

    List<OfficeModel> findAllByCnpj(String cnpj);
    Optional<OfficeModel> findByNomeAndCnpj(String nome, String cnpj);
    Optional<OfficeModel> findById(UUID id);
    Optional<OfficeModel> findIdByNomeAndCnpj(String name, String cnpj);
    boolean existsByNomeAndCnpj(String name, String cnpj);
}
