package finunsize.finunsizeapi.business.service.employee;

import finunsize.finunsizeapi.persistence.repository.employee.EmployeeRepository;

public class Employee implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public Employee (EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

}
