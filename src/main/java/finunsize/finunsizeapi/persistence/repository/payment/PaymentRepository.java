package finunsize.finunsizeapi.persistence.repository.payment;

import finunsize.finunsizeapi.persistence.model.payment.PaymentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PaymentRepository extends JpaRepository <PaymentModel, UUID> {
}
