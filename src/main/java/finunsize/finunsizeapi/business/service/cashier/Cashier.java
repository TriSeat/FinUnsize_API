package finunsize.finunsizeapi.business.service.cashier;

import finunsize.finunsizeapi.persistence.repository.cashier.CashierRepository;

public class Cashier implements CashierService {

    private final CashierRepository cashierRepository;

    public  Cashier (CashierRepository cashierRepository) {
        this.cashierRepository = cashierRepository;
    }

}
