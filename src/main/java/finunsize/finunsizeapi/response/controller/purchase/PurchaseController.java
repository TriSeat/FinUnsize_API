package finunsize.finunsizeapi.response.controller.purchase;

import finunsize.finunsizeapi.business.dto.purchase.PurchaseResponse;
import finunsize.finunsizeapi.business.service.purchase.PurchaseService;
import finunsize.finunsizeapi.persistence.model.purchase.PurchaseModel;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/compras")
public class PurchaseController {

    private final PurchaseService purchaseService;

    public PurchaseController(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }

    @GetMapping
    public List<PurchaseModel> viewPurchase() {
        List<PurchaseModel> purchase = purchaseService.viewPurchase();
        return purchase;
    }

    @PostMapping
    public ResponseEntity<PurchaseModel> createItems(@RequestBody @Valid PurchaseResponse purchaseDTO) {
        var purchaseModel = purchaseService.create(purchaseDTO);
        return ResponseEntity.ok(purchaseModel);
    }
}
