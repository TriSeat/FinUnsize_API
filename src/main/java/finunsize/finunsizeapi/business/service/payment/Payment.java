package finunsize.finunsizeapi.business.service.payment;

import finunsize.finunsizeapi.persistence.repository.payment.PaymentRepository;

public class Payment implements PaymentService {

    private final PaymentRepository paymentRepository;

    public Payment (PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

}
