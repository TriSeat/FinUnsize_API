package finunsize.finunsizeapi.response.controller.product;

import finunsize.finunsizeapi.business.dto.product.main.ProductCreate;
import finunsize.finunsizeapi.business.dto.product.main.ProductReponse;
import finunsize.finunsizeapi.business.dto.product.main.ProductUpdate;
import finunsize.finunsizeapi.business.service.product.main.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("product")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("create")
    public ResponseEntity create(@RequestBody @Valid ProductCreate productCreate) {
        productService.create(productCreate);
        return ResponseEntity.status(HttpStatus.CREATED).body("Produto cadastrado com sucesso");
    }

    @GetMapping("search/{name}")
    public ResponseEntity<ProductReponse> search(@PathVariable String name) {
        return ResponseEntity.ok(productService.find(name));
    }

    @GetMapping("find/{barras}")
    public ResponseEntity<ProductReponse> find(@PathVariable String barras) {
        return ResponseEntity.ok(productService.findByCod(barras));
    }

    @GetMapping("list")
    public ResponseEntity <List<ProductReponse>> list() {
        return ResponseEntity.ok(productService.list());
    }

    @PutMapping("update/{barras}")
    public ResponseEntity update(@PathVariable String barras, @Valid @RequestBody ProductUpdate productUpdate) {
        productService.update(barras, productUpdate);
        return ResponseEntity.ok("Produto Atualizado Com sucesso");
    }

    @DeleteMapping("delete/{barras}")
    public ResponseEntity<?> delete(@PathVariable String barras) {
        productService.delete(barras);
        return ResponseEntity.ok(String.format("Produto com o código de barras: %s excluído com sucesso", barras));
    }
}
