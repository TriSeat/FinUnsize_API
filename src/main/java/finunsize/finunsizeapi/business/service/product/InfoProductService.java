package finunsize.finunsizeapi.business.service.product;

import finunsize.finunsizeapi.business.dto.product.InfoProduct.InfoProductCreate;
import finunsize.finunsizeapi.business.dto.product.InfoProduct.InfoProductUpdate;
import finunsize.finunsizeapi.persistence.model.product.InfoProductModel;

import java.util.UUID;

public interface InfoProductService {
    InfoProductModel create(InfoProductCreate infoProductCreate);
    InfoProductModel update(UUID id, InfoProductUpdate infoProductUpdate);
    void delete(UUID id);
}
