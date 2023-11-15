package finunsize.finunsizeapi.business.service.expanse;

import finunsize.finunsizeapi.business.configuration.handler.EntityAlreadyExistsException;
import finunsize.finunsizeapi.business.dto.expanse.type.TypeExpanseCreate;
import finunsize.finunsizeapi.business.dto.expanse.type.TypeExpanseResponse;
import finunsize.finunsizeapi.integration.auth.UserSession;
import finunsize.finunsizeapi.persistence.model.expanse.TypeExpanseModel;
import finunsize.finunsizeapi.persistence.repository.expanse.TypeExpanseRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class TypeExpanse implements TypeExpanseService {

    private final TypeExpanseRepository typeExpanseRepository;
    private final UserSession userSession;

    public TypeExpanse(TypeExpanseRepository typeExpanseRepository, UserSession userSession) {
        this.typeExpanseRepository = typeExpanseRepository;
        this.userSession = userSession;
    }

    @Transactional
    @Override
    public TypeExpanseModel create(TypeExpanseCreate typeExpanseCreate) {
        TypeExpanseModel typeExpanseModel = new TypeExpanseModel();
        BeanUtils.copyProperties(typeExpanseCreate, typeExpanseModel, "id_despesa");
        valid(typeExpanseCreate.nome());
        typeExpanseModel.setCnpj(cnpj());
        return typeExpanseRepository.save(typeExpanseModel);
    }

    @Override
    public TypeExpanseResponse find(String name) {
       var type = typeExpanseRepository.findByNomeAndCnpj(name, cnpj())
               .orElseThrow(() -> new EntityNotFoundException(String.format("O tipo %s não foi encontrado", name)));
       return new TypeExpanseResponse(type);
    }

    @Override
    public List<TypeExpanseResponse> list() {
        var type = typeExpanseRepository.findByCnpj(cnpj());
        List<TypeExpanseResponse> response = type
                .stream()
                .map(TypeExpanseResponse::new)
                .collect(Collectors.toList());
        return response;
    }

    @Transactional
    @Override
    public TypeExpanseModel update(UUID id, @Valid TypeExpanseCreate typeExpanseCreate) {
        var type = typeExpanseRepository.findByIdDespesaAndCnpj(id, cnpj())
                .orElseThrow(() -> new EntityNotFoundException(String.format("o tipo com o id %s não foi encontrado", id.toString())));
        validUpdate(typeExpanseCreate.nome(), id);
        BeanUtils.copyProperties(typeExpanseCreate, type, "id_despesa");
        return typeExpanseRepository.save(type);
    }

    @Transactional
    @Override
    public void delete(UUID id) {
        var type = typeExpanseRepository.findByIdDespesaAndCnpj(id, cnpj())
                .orElseThrow(() -> new EntityNotFoundException(String.format("o tipo com o id %s não foi encontrado", id.toString())));
        typeExpanseRepository.delete(type);
    }

    private void valid(String name) {
        if(typeExpanseRepository.existsByNomeAndCnpj(name, cnpj())) {
            throw new EntityAlreadyExistsException(String.format("O tipo de despesa %s, já está cadastrado", name));
        }
    }

    private void validUpdate(String name, UUID id) {
        if(typeExpanseRepository.existsByNomeAndIdDespesaNot(name, id))
            throw new EntityAlreadyExistsException(String.format("O tipo de despesa %s, já está cadastrado", name));
    }

    private String cnpj() {
        return userSession.getSessionCnpj();
    }
}
