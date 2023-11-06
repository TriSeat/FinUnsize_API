package finunsize.finunsizeapi.persistence.repository.employee;

import finunsize.finunsizeapi.persistence.model.employee.OfficeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OfficeRepository extends JpaRepository <OfficeModel, UUID> {

    OfficeModel findByNome(String nome);

}
