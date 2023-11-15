package finunsize.finunsizeapi.business.service.employee.main;

import finunsize.finunsizeapi.business.dto.employee.main.EmployeeCreate;
import finunsize.finunsizeapi.business.dto.employee.main.EmployeeResponse;
import finunsize.finunsizeapi.business.dto.employee.main.EmployeeUpdate;
import finunsize.finunsizeapi.persistence.model.employee.EmployeeModel;

import java.util.List;

public interface EmployeeService {
    EmployeeModel create(EmployeeCreate employeeCreate);
    EmployeeResponse find(String cpf);
    List<EmployeeResponse> list();
    EmployeeModel update(String cpf, EmployeeUpdate employeeUpdate);
    void delete(String cpf);
}
