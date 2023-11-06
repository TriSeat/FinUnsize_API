package finunsize.finunsizeapi.business.service.product;

import finunsize.finunsizeapi.persistence.model.product.InfoProductModel;

public interface InfoProductService {
    InfoProductModel create(InfoProductModel infoProductModel);
    InfoProductModel update(InfoProductModel infoProductModel);
    void delete();
}
