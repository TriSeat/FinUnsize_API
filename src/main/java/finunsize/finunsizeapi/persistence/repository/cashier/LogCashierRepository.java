package finunsize.finunsizeapi.persistence.repository.cashier;

import finunsize.finunsizeapi.persistence.model.cashier.LogCashierModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface LogCashierRepository extends JpaRepository <LogCashierModel, UUID> {
}
