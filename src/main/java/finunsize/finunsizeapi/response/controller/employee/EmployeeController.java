package finunsize.finunsizeapi.response.controller.employee;

import finunsize.finunsizeapi.business.dto.employee.main.EmployeeCreate;
import finunsize.finunsizeapi.business.dto.employee.main.EmployeeResponse;
import finunsize.finunsizeapi.business.dto.employee.main.EmployeeUpdate;
import finunsize.finunsizeapi.business.service.employee.main.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("create")
    public ResponseEntity create(@RequestBody @Valid EmployeeCreate employeeCreate) {
        employeeService.create(employeeCreate);
        return ResponseEntity.status(HttpStatus.CREATED).body("Funcionário criado com sucesso");
    }

    @GetMapping("find/{cpf}")
    public ResponseEntity<EmployeeResponse> find(@PathVariable String cpf) {
        return ResponseEntity.ok(employeeService.find(cpf));
    }

    @GetMapping("list")
    public ResponseEntity<List<EmployeeResponse>> list() {
        return ResponseEntity.ok(employeeService.list());
    }

    @PutMapping("update/{cpf}")
    public ResponseEntity update(@PathVariable String cpf, @RequestBody @Valid EmployeeUpdate employeeUpdate) {
        employeeService.update(cpf, employeeUpdate);
        return ResponseEntity.ok("Funcionário atualizado com sucesso");
    }

    @PostMapping("delete/{cpf}")
    public ResponseEntity<?> delete(@PathVariable String cpf) {
        employeeService.delete(cpf);
        return ResponseEntity.ok(String.format("Funcionário com o cpf de: %s excluído com sucesso", cpf));
    }
}