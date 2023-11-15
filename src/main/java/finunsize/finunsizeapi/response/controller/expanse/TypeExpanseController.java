package finunsize.finunsizeapi.response.controller.expanse;

import finunsize.finunsizeapi.business.configuration.handler.user.ContextNullException;
import finunsize.finunsizeapi.business.dto.expanse.type.TypeExpanseCreate;
import finunsize.finunsizeapi.business.dto.expanse.type.TypeExpanseResponse;
import finunsize.finunsizeapi.business.service.expanse.TypeExpanseService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("expanse/type")
public class TypeExpanseController {

    private final TypeExpanseService typeExpanseService;

    public TypeExpanseController(TypeExpanseService typeExpanseService) {
        this.typeExpanseService = typeExpanseService;
    }

    @PostMapping("create")
    public ResponseEntity create(@RequestBody @Valid TypeExpanseCreate typeExpanseCreate) throws ContextNullException {
        typeExpanseService.create(typeExpanseCreate);
        return ResponseEntity.status(HttpStatus.CREATED).body("Tipo de despesa criada com sucesso");
    }

    @GetMapping("find/{name}")
    public ResponseEntity<TypeExpanseResponse> find(@PathVariable String name) throws ContextNullException {
        return ResponseEntity.ok(typeExpanseService.find(name));
    }

    @GetMapping("list")
    public ResponseEntity<List<TypeExpanseResponse>> list() throws ContextNullException {
        return ResponseEntity.ok(typeExpanseService.list());
    }

    @PutMapping("update/{id}")
    public ResponseEntity update(@PathVariable UUID id, @RequestBody @Valid TypeExpanseCreate typeExpanseCreate) throws ContextNullException {
        typeExpanseService.update(id, typeExpanseCreate);
        return ResponseEntity.ok("Tipo de despesa atualizada com sucesso");
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity delete(@PathVariable UUID id) throws ContextNullException {
        typeExpanseService.delete(id);
        return ResponseEntity.ok("Tipo de despesa excluída com sucesso");
    }
}
