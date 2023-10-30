package finunsize.finunsizeapi.business.service.purchase;

import finunsize.finunsizeapi.business.dto.purchase.PurchaseResponse;
import finunsize.finunsizeapi.business.dto.purchase.PurchaseItemResponse;
import finunsize.finunsizeapi.persistence.model.purchase.PurchaseItemModel;
import finunsize.finunsizeapi.persistence.model.purchase.PurchaseModel;
import finunsize.finunsizeapi.persistence.repository.purchase.PurchaseRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class Purchase implements PurchaseService {


    private final PurchaseRepository purchaseRepository;
    PurchaseModel purchaseModel;
    PurchaseItemModel purchaseItemModel;


    public Purchase (PurchaseRepository purchaseRepository) {
        this.purchaseRepository = purchaseRepository;
        purchaseModel = new PurchaseModel();
        purchaseItemModel = new PurchaseItemModel();
    }

    @Override
    public List<PurchaseModel> viewPurchase() {
        return purchaseRepository.findAll();
    }

    @Override
    @Transactional
    public PurchaseModel create(@Valid PurchaseResponse purchaseDTO) {

        BeanUtils.copyProperties(purchaseDTO, purchaseModel);
        List<PurchaseItemModel> items = createItems(purchaseModel, purchaseDTO.purchaseItem());
        purchaseModel.setPurchase_item(items);

        return purchaseRepository.save(purchaseModel);
    }

    private List<PurchaseItemModel> createItems(PurchaseModel purchaseModel, List<PurchaseItemResponse> purchaseItemDTOS) {

        List<PurchaseItemModel> items = new ArrayList<>();

        for (PurchaseItemResponse purchaseItemDTO : purchaseItemDTOS) {
            BeanUtils.copyProperties(purchaseItemDTO, purchaseItemModel);
            purchaseItemModel.setPurchase(purchaseModel);
            items.add(purchaseItemModel);
        }
        return items;
    }


    @Override
    @Transactional
    public PurchaseModel update(UUID Id, PurchaseResponse purchaseDTO) {
        return null;
    }

    @Override
    public PurchaseModel findByName(String name) {
        return null;
    }

    @Override
    @Transactional
    public void delete(UUID id) {

    }

}
