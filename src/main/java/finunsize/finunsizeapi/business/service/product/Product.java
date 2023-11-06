package finunsize.finunsizeapi.business.service.product;

import finunsize.finunsizeapi.persistence.model.product.ProductModel;
import finunsize.finunsizeapi.persistence.repository.product.ProductRepository;

public class Product implements ProductService {

    private final ProductRepository productRepository;

    public Product (ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductModel create(ProductModel productModel) {
        return null;
    }

    @Override
    public ProductModel update(ProductModel productModel) {
        return null;
    }

    @Override
    public void delete() {

    }
}
