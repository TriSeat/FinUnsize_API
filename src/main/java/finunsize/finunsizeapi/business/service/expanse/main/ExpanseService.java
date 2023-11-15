package finunsize.finunsizeapi.business.service.expanse.main;

import finunsize.finunsizeapi.business.configuration.handler.user.ContextNullException;
import finunsize.finunsizeapi.business.dto.expanse.main.ExpanseCreate;
import finunsize.finunsizeapi.business.dto.expanse.main.ExpanseResponse;
import finunsize.finunsizeapi.persistence.model.expanse.ExpanseModel;

import java.util.List;
import java.util.UUID;

public interface ExpanseService {
    ExpanseModel create(ExpanseCreate expanseCreate) throws ContextNullException;
    ExpanseResponse find(String name) throws ContextNullException;
    List<ExpanseResponse> list() throws ContextNullException;
    ExpanseModel update(UUID id, ExpanseCreate expanseCreate) throws ContextNullException;
    void delete(UUID id) throws ContextNullException;
}
