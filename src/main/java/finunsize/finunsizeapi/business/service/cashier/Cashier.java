package finunsize.finunsizeapi.business.service.cashier;

import finunsize.finunsizeapi.persistence.model.cashier.CashierModel;
import finunsize.finunsizeapi.persistence.repository.cashier.CashierRepository;

public class Cashier implements CashierService {

    private final CashierRepository cashierRepository;

    public  Cashier (CashierRepository cashierRepository) {
        this.cashierRepository = cashierRepository;
    }

    @Override
    public CashierModel create(CashierModel cashierModel) {
        return null;
    }

    @Override
    public CashierModel update(CashierModel cashierModel) {
        return null;
    }

    @Override
    public void delete() {

    }
}
