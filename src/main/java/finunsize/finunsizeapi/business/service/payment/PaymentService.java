package finunsize.finunsizeapi.business.service.payment;

import finunsize.finunsizeapi.persistence.model.payment.PaymentModel;

public interface PaymentService {
    PaymentModel create(PaymentModel paymentModel);
    PaymentModel update(PaymentModel paymentModel);
    void delete();
}
