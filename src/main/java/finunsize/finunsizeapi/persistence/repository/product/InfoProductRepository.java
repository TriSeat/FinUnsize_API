package finunsize.finunsizeapi.persistence.repository.product;

import finunsize.finunsizeapi.persistence.model.product.InfoProductModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface InfoProductRepository extends JpaRepository<InfoProductModel, UUID> {
}
