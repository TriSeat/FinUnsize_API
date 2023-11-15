package finunsize.finunsizeapi.business.service.expanse.main;

import finunsize.finunsizeapi.business.dto.expanse.main.ExpanseCreate;
import finunsize.finunsizeapi.business.dto.expanse.main.ExpanseResponse;
import finunsize.finunsizeapi.persistence.model.expanse.ExpanseModel;

import java.util.List;
import java.util.UUID;

public interface ExpanseService {
    ExpanseModel create(ExpanseCreate expanseCreate);
    ExpanseResponse find(String name);
    List<ExpanseResponse> list();
    ExpanseModel update(UUID id, ExpanseCreate expanseCreate);
    void delete(UUID id);
}
