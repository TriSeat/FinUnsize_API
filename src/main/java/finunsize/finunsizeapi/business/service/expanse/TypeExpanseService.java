package finunsize.finunsizeapi.business.service.expanse;

import finunsize.finunsizeapi.business.dto.expanse.type.TypeExpanseCreate;
import finunsize.finunsizeapi.business.dto.expanse.type.TypeExpanseResponse;
import finunsize.finunsizeapi.persistence.model.expanse.TypeExpanseModel;

import java.util.List;
import java.util.UUID;

public interface TypeExpanseService {
    TypeExpanseModel create(TypeExpanseCreate typeExpanseCreate);
    TypeExpanseResponse find(String name);
    List<TypeExpanseResponse> list();
    TypeExpanseModel update(UUID id, TypeExpanseCreate typeExpanseCreate);
    void delete(UUID id);
}