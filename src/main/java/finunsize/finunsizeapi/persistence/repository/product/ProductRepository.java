package finunsize.finunsizeapi.persistence.repository.product;

import finunsize.finunsizeapi.persistence.model.product.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository <ProductModel, String> {
    Optional<ProductModel> findByCodBarrasAndCnpj(String barras, String cnpj);
    Optional<ProductModel> findByNomeAndCnpj(String name, String cnpj);
    List<ProductModel> findByCnpj(String cnpj);
    boolean existsByCodBarrasAndCnpj(String barras, String cnpj);
}
