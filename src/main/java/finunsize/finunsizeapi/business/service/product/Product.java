package finunsize.finunsizeapi.business.service.product;

import finunsize.finunsizeapi.persistence.repository.product.ProductRepository;

public class Product implements ProductService {

    private final ProductRepository productRepository;

    public Product (ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

}
