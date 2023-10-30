package finunsize.finunsizeapi.persistence.repository.sale;

import finunsize.finunsizeapi.persistence.model.sale.SaleModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SaleRepository extends JpaRepository <SaleModel, UUID> {
}
