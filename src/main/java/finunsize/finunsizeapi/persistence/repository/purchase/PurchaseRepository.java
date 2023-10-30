package finunsize.finunsizeapi.persistence.repository.purchase;

import finunsize.finunsizeapi.persistence.model.purchase.PurchaseModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PurchaseRepository extends JpaRepository <PurchaseModel, UUID> {

}
