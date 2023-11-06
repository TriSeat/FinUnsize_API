package finunsize.finunsizeapi.business.service.employee;

import finunsize.finunsizeapi.business.configuration.handler.user.ContextNullException;
import finunsize.finunsizeapi.business.dto.employee.main.EmployeeCreate;
import finunsize.finunsizeapi.business.dto.employee.main.EmployeeResponse;
import finunsize.finunsizeapi.business.dto.employee.main.EmployeeUpdate;
import finunsize.finunsizeapi.integration.auth.UserSession;
import finunsize.finunsizeapi.persistence.model.employee.EmployeeModel;
import finunsize.finunsizeapi.persistence.repository.address.AddressRepository;
import finunsize.finunsizeapi.persistence.repository.employee.EmployeeRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class Employee implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final AddressRepository addressRepository;
    private final UserSession userSession;

    @Autowired
    public Employee (EmployeeRepository employeeRepository, AddressRepository addressRepository, UserSession userSession) {
        this.employeeRepository = employeeRepository;
        this.addressRepository = addressRepository;
        this.userSession = userSession;
    }

    @Transactional
    @Override
    public EmployeeModel create(@Valid EmployeeCreate employeeCreate) throws ContextNullException {
        EmployeeModel employeeModel = new EmployeeModel();
        BeanUtils.copyProperties(employeeCreate, employeeModel);
        insertCompany(employeeModel);
        return employeeRepository.save(employeeModel);
    }

    @Override
    public List<EmployeeResponse> list(String name) throws ContextNullException {
        String cnpj = userSession.getSessionCnpj();
    }

    @Transactional
    @Override
    public EmployeeModel update(EmployeeUpdate employeeUpdate) {
        return null;
    }

    @Transactional
    @Override
    public void delete() {

    }

    public void insertCompany(EmployeeModel employeeModel) throws ContextNullException {
        String cnpj = userSession.getSessionCnpj();
        employeeModel.setCnpj(cnpj);
    }
}
