package finunsize.finunsizeapi.business.service.expanse.main;

import finunsize.finunsizeapi.business.configuration.handler.EntityAlreadyExistsException;
import finunsize.finunsizeapi.business.dto.expanse.main.ExpanseCreate;
import finunsize.finunsizeapi.business.dto.expanse.main.ExpanseResponse;
import finunsize.finunsizeapi.integration.auth.UserSession;
import finunsize.finunsizeapi.persistence.model.expanse.ExpanseModel;
import finunsize.finunsizeapi.persistence.repository.expanse.ExpanseRepository;
import finunsize.finunsizeapi.persistence.repository.expanse.TypeExpanseRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class Expanse implements ExpanseService {

    private final ExpanseRepository expanseRepository;
    private final TypeExpanseRepository typeExpanseRepository;
    private final UserSession userSession;

    @Autowired
    public Expanse(ExpanseRepository expanseRepository, TypeExpanseRepository typeExpanseRepository, UserSession userSession) {
        this.expanseRepository = expanseRepository;
        this.typeExpanseRepository = typeExpanseRepository;
        this.userSession = userSession;
    }

    @Transactional
    @Override
    public ExpanseModel create(@Valid ExpanseCreate expanseCreate) {
        ExpanseModel expanseModel = new ExpanseModel();
        valid(expanseCreate.nome());
        BeanUtils.copyProperties(expanseCreate, expanseModel, "id_despesa");
        insertFk(expanseModel, expanseCreate.tipo_despesa());
        expanseModel.setCnpj(cnpj());
        return expanseRepository.save(expanseModel);
    }

    @Override
    public ExpanseResponse find(String name) {
        var expanse = expanseRepository.findByNomeAndCnpj(name, cnpj())
                .orElseThrow(() -> new EntityNotFoundException(String.format("A depesa %s, não está cadastrada", name)));
        return new ExpanseResponse(expanse);
    }

    @Override
    public List<ExpanseResponse> list() {
        var expanse = expanseRepository.findAllByCnpj(cnpj());
        List<ExpanseResponse> response = expanse
                .stream()
                .map(ExpanseResponse::new)
                .collect(Collectors.toList());
        return response;
    }

    @Transactional
    @Override
    public ExpanseModel update(UUID id, @Valid ExpanseCreate expanseCreate) {
        var expanse = expanseRepository.findByIdDespesaAndCnpj(id, cnpj())
                .orElseThrow(() -> new EntityNotFoundException(String.format("Despesa %s não foi encontrada", id.toString())));
        validUpdate(id, expanseCreate.nome());
        BeanUtils.copyProperties(expanseCreate, expanse, "id_despesa");
        return expanseRepository.save(expanse);
    }

    @Transactional
    @Override
    public void delete(UUID id) {
        var expanse = expanseRepository.findByIdDespesaAndCnpj(id, cnpj())
                .orElseThrow(() -> new EntityNotFoundException(String.format("Despesa %s não foi encontrada", id.toString())));
        expanseRepository.delete(expanse);
    }

    private void insertFk(ExpanseModel expanseModel, String name) {
        var type = typeExpanseRepository.findIdByNomeAndCnpj(name, cnpj())
                .orElseThrow(() -> new EntityNotFoundException(String.format("O tipo da despesa %s, não foi econtrado", name)));
        expanseModel.setTipo_despesa(type);
    }

    public String cnpj() {
        return userSession.getSessionCnpj();
    }

    private void valid(String name) {
        if(expanseRepository.existsByNomeAndCnpj(name, cnpj()))
            throw new EntityAlreadyExistsException(String.format("A despesa %s, já foi cadastrada", name));
    }

    private void validUpdate(UUID id, String name) {
        if(expanseRepository.existsByNomeAndIdDespesaNot(name, id))
            throw new EntityAlreadyExistsException(String.format("A despesa %s, já foi cadastrada", name));
    }
}
