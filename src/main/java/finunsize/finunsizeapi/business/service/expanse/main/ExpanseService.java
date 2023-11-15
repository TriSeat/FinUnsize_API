package finunsize.finunsizeapi.business.service.expanse;

import finunsize.finunsizeapi.persistence.model.expanse.ExpanseModel;

public interface ExpanseService {
    ExpanseModel create(ExpanseModel expanseModel);
    ExpanseModel update(ExpanseModel expanseModel);
    void delete();
}
