package finunsize.finunsizeapi.persistence.repository.cashier;

import finunsize.finunsizeapi.persistence.model.cashier.CashierModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CashierRepository extends JpaRepository <CashierModel, Integer> {
}
