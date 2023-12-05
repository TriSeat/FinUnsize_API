package finunsize.finunsizeapi.response.controller.product;

import finunsize.finunsizeapi.business.dto.product.supplier.SupplierCreate;
import finunsize.finunsizeapi.business.dto.product.supplier.SupplierResponse;
import finunsize.finunsizeapi.business.dto.product.supplier.SupplierUpdate;
import finunsize.finunsizeapi.business.service.supplier.SupplierService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("supplier")
public class SupplierController {

    private final SupplierService supplierService;

    public SupplierController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    @PostMapping("create")
    public ResponseEntity create(@RequestBody @Valid SupplierCreate supplierCreate) {
        supplierService.create(supplierCreate);
        return ResponseEntity.status(HttpStatus.CREATED).body("Fornecedor cadastrado com sucesso");
    }

    @GetMapping("search/{name}")
    public ResponseEntity<SupplierResponse> search(@PathVariable String name) {
        return ResponseEntity.ok(supplierService.find(name));
    }

    @GetMapping("find/{id}")
    public ResponseEntity<SupplierResponse> find(@PathVariable UUID id) {
        return ResponseEntity.ok(supplierService.findById(id));
    }

    @GetMapping("list")
    public ResponseEntity <List<SupplierResponse>> list() {
        return ResponseEntity.ok(supplierService.list());
    }

    @PutMapping("update/{id}")
    public ResponseEntity update(@PathVariable UUID id, @Valid @RequestBody SupplierUpdate supplierUpdate) {
        supplierService.update(id, supplierUpdate);
        return ResponseEntity.ok("Fornecedor Atualizado Com sucesso");
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> delete(@PathVariable UUID id) {
        supplierService.delete(id);
        return ResponseEntity.ok(String.format("Fornecedor com o id : %s excluído com sucesso", id));
    }
}
