package finunsize.finunsizeapi.business.service.employee.main;

import finunsize.finunsizeapi.business.configuration.handler.user.ContextNullException;
import finunsize.finunsizeapi.business.dto.address.AddressCreate;
import finunsize.finunsizeapi.business.dto.address.AddressUpdate;
import finunsize.finunsizeapi.business.dto.employee.main.EmployeeCreate;
import finunsize.finunsizeapi.business.dto.employee.main.EmployeeResponse;
import finunsize.finunsizeapi.business.dto.employee.main.EmployeeUpdate;
import finunsize.finunsizeapi.persistence.model.employee.EmployeeModel;

import java.util.List;
import java.util.UUID;

public interface EmployeeService {
    EmployeeModel create(EmployeeCreate employeeCreate) throws ContextNullException;
    EmployeeResponse find(String cpf);
    List<EmployeeResponse> list() throws ContextNullException;
    EmployeeModel update(String cpf, UUID id_logradouro, EmployeeUpdate employeeUpdate);
    void delete(String cpf);
}
