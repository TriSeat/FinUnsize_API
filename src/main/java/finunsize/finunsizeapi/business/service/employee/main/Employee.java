package finunsize.finunsizeapi.business.service.employee.main;

import finunsize.finunsizeapi.business.configuration.handler.EntityAlreadyExistsException;
import finunsize.finunsizeapi.business.configuration.handler.user.ContextNullException;
import finunsize.finunsizeapi.business.dto.employee.main.EmployeeCreate;
import finunsize.finunsizeapi.business.dto.employee.main.EmployeeResponse;
import finunsize.finunsizeapi.business.dto.employee.main.EmployeeUpdate;
import finunsize.finunsizeapi.business.service.address.Address;
import finunsize.finunsizeapi.business.service.address.AddressService;
import finunsize.finunsizeapi.integration.auth.UserSession;
import finunsize.finunsizeapi.persistence.model.address.AddressModel;
import finunsize.finunsizeapi.persistence.model.employee.EmployeeModel;
import finunsize.finunsizeapi.persistence.repository.employee.EmployeeRepository;
import finunsize.finunsizeapi.persistence.repository.employee.OfficeRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class Employee implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final OfficeRepository officeRepository;
    private final AddressService addressService;
    private final UserSession userSession;

    @Autowired
    public Employee (EmployeeRepository employeeRepository, OfficeRepository officeRepository, AddressService addressService, UserSession userSession) {
        this.employeeRepository = employeeRepository;
        this.officeRepository = officeRepository;
        this.addressService = addressService;
        this.userSession = userSession;
    }

    @Transactional
    @Override
    public EmployeeModel create(@Valid EmployeeCreate employeeCreate) throws ContextNullException {
        EmployeeModel employeeModel = new EmployeeModel();
        valid(employeeCreate.cpf());
        BeanUtils.copyProperties(employeeCreate, employeeModel, "id_funcionario");
        var address = addressService.create(employeeCreate.endereco());
        insertFk(employeeModel, employeeCreate.cargo(), address);
        return employeeRepository.save(employeeModel);
    }

    @Override
    public EmployeeResponse find(String cpf) {
        var employee = employeeRepository.findByCpf(cpf)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Funcionário com o cpf: %s, não encontrado", cpf)));
        return new EmployeeResponse(employee);
    }

    @Override
    public List<EmployeeResponse> list() throws ContextNullException {
        List<EmployeeModel> employees = employeeRepository.findAllByCnpjAndDemitidoIsFalse(cnpj());
        List<EmployeeResponse> response = employees
                .stream()
                .map(EmployeeResponse::new)
                .collect(Collectors.toList());
        return response;
    }

    @Transactional
    @Override
    public EmployeeModel update(String cpf, UUID id_logradouro, @Valid EmployeeUpdate employeeUpdate) {
        var employee = employeeRepository.findByCpf(cpf)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Funcionário com o cpf de: %s não foi encontrado", cpf)));
        valid(employeeUpdate.cpf());
        BeanUtils.copyProperties(employeeUpdate, employee, "id_funcionario");
        addressService.update(id_logradouro, employeeUpdate.addressUpdate());
        return employeeRepository.save(employee);
    }

    @Transactional
    @Override
    public void delete(String cpf) {
        var employee = employeeRepository.findByCpf(cpf)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Funcionário com o cpf de: %s não foi encontrado", cpf)));
        employee.setDemitido(true);
        employeeRepository.save(employee);
    }

    public void insertFk(EmployeeModel employeeModel, String office, AddressModel address) throws ContextNullException {
        String cnpj = userSession.getSessionCnpj();
        var offices = officeRepository.findByNome(office);
        employeeModel.setCargo(offices);
        employeeModel.setId_logradouro(address);
        employeeModel.setCnpj(cnpj);
    }

    public String cnpj() throws ContextNullException {
        return userSession.getSessionCnpj();
    }

    private void valid(String cpf) {
        if(employeeRepository.existsByCpf(cpf))
            throw new EntityAlreadyExistsException(String.format("O CPF %s já está cadastrado", cpf));
    }
}
