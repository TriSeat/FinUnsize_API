package finunsize.finunsizeapi.business.service.payment;

import finunsize.finunsizeapi.persistence.model.payment.PaymentModel;
import finunsize.finunsizeapi.persistence.repository.payment.PaymentRepository;

public class Payment implements PaymentService {

    private final PaymentRepository paymentRepository;

    public Payment (PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Override
    public PaymentModel create(PaymentModel paymentModel) {
        return null;
    }

    @Override
    public PaymentModel update(PaymentModel paymentModel) {
        return null;
    }

    @Override
    public void delete() {

    }
}
