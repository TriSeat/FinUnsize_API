package finunsize.finunsizeapi.business.service.employee;

import finunsize.finunsizeapi.business.configuration.handler.user.ContextNullException;
import finunsize.finunsizeapi.business.dto.employee.main.EmployeeCreate;
import finunsize.finunsizeapi.business.dto.employee.main.EmployeeResponse;
import finunsize.finunsizeapi.business.dto.employee.main.EmployeeUpdate;
import finunsize.finunsizeapi.persistence.model.employee.EmployeeModel;

import java.util.List;

public interface EmployeeService {
    EmployeeModel create(EmployeeCreate employeeCreate) throws ContextNullException;
    List<EmployeeResponse> list(String name) throws ContextNullException;
    EmployeeModel update(EmployeeUpdate employeeUpdate);
    void delete();
}
