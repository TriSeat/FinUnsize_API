package finunsize.finunsizeapi.business.service.purchase;

import finunsize.finunsizeapi.business.dto.purchase.PurchaseResponse;
import finunsize.finunsizeapi.persistence.model.purchase.PurchaseModel;

import java.util.List;
import java.util.UUID;

public interface PurchaseService {
    PurchaseModel create(PurchaseResponse purchaseDTO);
    PurchaseModel update(UUID Id, PurchaseResponse purchaseDTO);
    PurchaseModel findByName(String name);
    void delete(UUID id);
    List<PurchaseModel> viewPurchase();
}
