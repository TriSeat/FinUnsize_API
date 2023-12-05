package finunsize.finunsizeapi.business.service.product.main;

import finunsize.finunsizeapi.business.dto.product.main.ProductCreate;
import finunsize.finunsizeapi.business.dto.product.main.ProductReponse;
import finunsize.finunsizeapi.business.dto.product.main.ProductUpdate;
import finunsize.finunsizeapi.persistence.model.product.ProductModel;

import java.util.List;

public interface ProductService {
    ProductModel create(ProductCreate productCreate);
    ProductReponse find(String name);
    ProductReponse findByCod(String barras);
    List<ProductReponse> list();
    ProductModel update(String barras, ProductUpdate productUpdate);
    void delete(String barras);
}
