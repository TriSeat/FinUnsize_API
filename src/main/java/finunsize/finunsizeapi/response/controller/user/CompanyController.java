package finunsize.finunsizeapi.response.controller.user;

import finunsize.finunsizeapi.business.configuration.handler.user.ContextNullException;
import finunsize.finunsizeapi.business.dto.user.company.CompanyCreate;
import finunsize.finunsizeapi.business.dto.user.company.CompanyResponse;
import finunsize.finunsizeapi.business.dto.user.company.CompanyUpdate;
import finunsize.finunsizeapi.business.service.user.company.CompanyService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("company")
public class CompanyController {

    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @PostMapping("create")
    public ResponseEntity create(@RequestBody @Valid CompanyCreate companyCreate) {
        companyService.create(companyCreate);
        return ResponseEntity.status(HttpStatus.CREATED).body("Empresa criada com sucesso");
    }

    @GetMapping("credentials")
    public ResponseEntity<CompanyResponse> credentials() throws ContextNullException {
        var company = companyService.find();
        return ResponseEntity.ok(company);
    }

    @PutMapping("update")
    public ResponseEntity update(@RequestBody @Valid CompanyUpdate companyUpdate) throws ContextNullException {
        companyService.update(companyUpdate);
        return  ResponseEntity.ok("Empresa Atualizada");
    }
}
