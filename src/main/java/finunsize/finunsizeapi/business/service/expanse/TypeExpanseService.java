package finunsize.finunsizeapi.business.service.expanse;

import finunsize.finunsizeapi.business.configuration.handler.user.ContextNullException;
import finunsize.finunsizeapi.business.dto.expanse.type.TypeExpanseCreate;
import finunsize.finunsizeapi.business.dto.expanse.type.TypeExpanseResponse;
import finunsize.finunsizeapi.persistence.model.expanse.TypeExpanseModel;

import java.util.List;
import java.util.UUID;

public interface TypeExpanseService {
    TypeExpanseModel create(TypeExpanseCreate typeExpanseCreate) throws ContextNullException;
    TypeExpanseResponse find(String name) throws ContextNullException;
    List<TypeExpanseResponse> list() throws ContextNullException;
    TypeExpanseModel update(UUID id, TypeExpanseCreate typeExpanseCreate) throws ContextNullException;
    void delete(UUID id) throws ContextNullException;
}