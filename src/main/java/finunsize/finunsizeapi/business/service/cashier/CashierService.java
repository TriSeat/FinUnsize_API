package finunsize.finunsizeapi.business.service.cashier;

import finunsize.finunsizeapi.persistence.model.cashier.CashierModel;

public interface CashierService {
    CashierModel create(CashierModel cashierModel);
    CashierModel update(CashierModel cashierModel);
    void delete();
}
