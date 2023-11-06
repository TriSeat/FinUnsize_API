package finunsize.finunsizeapi.business.service.product;

import finunsize.finunsizeapi.persistence.model.product.ProductModel;

public interface ProductService {
    ProductModel create(ProductModel productModel);

    ProductModel update(ProductModel productModel);
    void delete();
}
