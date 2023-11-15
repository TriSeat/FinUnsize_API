package finunsize.finunsizeapi.response.controller.expanse;

import finunsize.finunsizeapi.business.configuration.handler.user.ContextNullException;
import finunsize.finunsizeapi.business.dto.expanse.main.ExpanseCreate;
import finunsize.finunsizeapi.business.dto.expanse.main.ExpanseResponse;
import finunsize.finunsizeapi.business.service.expanse.main.ExpanseService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("expanse")
public class ExpanseController {


    private final ExpanseService expanseService;

    public ExpanseController(ExpanseService expanseService) {
        this.expanseService = expanseService;
    }

    @PostMapping("create")
    public ResponseEntity create(@RequestBody @Valid ExpanseCreate expanseCreate) throws ContextNullException {
        expanseService.create(expanseCreate);
        return ResponseEntity.status(HttpStatus.CREATED).body("Despesa cadastrada com sucesso");
    }

    @GetMapping("find/{name}")
    public ResponseEntity<ExpanseResponse> find(@PathVariable String name) throws ContextNullException {
        return ResponseEntity.ok(expanseService.find(name));
    }

    @GetMapping("list")
    public ResponseEntity<List<ExpanseResponse>> list() throws ContextNullException {
        return ResponseEntity.ok(expanseService.list());
    }

    @PutMapping("update/{id}")
    public ResponseEntity update(@PathVariable UUID id, @RequestBody ExpanseCreate expanseCreate) throws ContextNullException {
        expanseService.update(id, expanseCreate);
        return ResponseEntity.ok(String.format("Despesa %s atualizada com sucesso", id.toString()));
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity delete(@PathVariable UUID id) throws ContextNullException {
        expanseService.delete(id);
        return ResponseEntity.ok(String.format("Despesa %s excluída com sucesso", id.toString()));
    }

}
