package finunsize.finunsizeapi.persistence.repository.product;

import finunsize.finunsizeapi.persistence.model.product.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository <ProductModel, String> {
}
