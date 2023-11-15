package finunsize.finunsizeapi.persistence.repository.employee;

import finunsize.finunsizeapi.persistence.model.employee.EmployeeModel;
import finunsize.finunsizeapi.persistence.model.employee.OfficeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository <EmployeeModel, Integer> {
    List<EmployeeModel> findAllByCnpjAndDemitidoIsFalse(String cnpj);
    Optional<EmployeeModel> findByCpfAndCnpjAndDemitidoIsFalse(String cpf, String cnpj);
    boolean existsByCpf(String cpf);
}
