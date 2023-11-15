package finunsize.finunsizeapi.response.controller.employee;

import finunsize.finunsizeapi.business.configuration.handler.user.ContextNullException;
import finunsize.finunsizeapi.business.dto.employee.office.OfficeCreate;
import finunsize.finunsizeapi.business.dto.employee.office.OfficeResponse;
import finunsize.finunsizeapi.business.service.employee.OfficeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("office")
public class OfficeController {

    private final OfficeService officeService;

    public OfficeController(OfficeService officeService) {
        this.officeService = officeService;
    }

    @PostMapping("create")
    public ResponseEntity create(@RequestBody @Valid OfficeCreate officeCreate) {
        officeService.create(officeCreate);
        return ResponseEntity.status(HttpStatus.CREATED).body("Cargo criado com sucesso");
    }

    @GetMapping("find/{name}")
    public ResponseEntity<OfficeResponse> find(@PathVariable String name) {
        return ResponseEntity.ok(officeService.find(name));
    }

    @GetMapping("list")
    public ResponseEntity<List<OfficeResponse>> list() {
        return ResponseEntity.ok(officeService.list());
    }

    @PutMapping("update/{id}")
    public ResponseEntity update(@PathVariable UUID id, @RequestBody @Valid OfficeCreate officeCreate) {
        officeService.update(id, officeCreate);
        return ResponseEntity.ok("Funcionário atualizado com sucesso");
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity delete(@PathVariable UUID id) {
        officeService.delete(id);
        return ResponseEntity.ok("Cargo excluído com sucesso");
    }
}
