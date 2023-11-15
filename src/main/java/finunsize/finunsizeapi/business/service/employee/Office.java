package finunsize.finunsizeapi.business.service.employee;

import finunsize.finunsizeapi.business.configuration.handler.EntityAlreadyExistsException;
import finunsize.finunsizeapi.business.configuration.handler.user.ContextNullException;
import finunsize.finunsizeapi.business.dto.employee.office.OfficeCreate;
import finunsize.finunsizeapi.business.dto.employee.office.OfficeResponse;
import finunsize.finunsizeapi.integration.auth.UserSession;
import finunsize.finunsizeapi.persistence.model.employee.OfficeModel;
import finunsize.finunsizeapi.persistence.repository.employee.OfficeRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class Office implements OfficeService {

    private final OfficeRepository officeRepository;
    private final UserSession userSession;

    public Office (OfficeRepository officeRepository, UserSession userSession) {
        this.officeRepository = officeRepository;
        this.userSession = userSession;
    }

    @Transactional
    @Override
    public OfficeModel create(@Valid OfficeCreate officeCreate) throws ContextNullException {
        OfficeModel officeModel = new OfficeModel();
        valid(officeCreate.nome());
        BeanUtils.copyProperties(officeCreate, officeModel, "id_cargo");
        officeModel.setCnpj(cnpj());
        return officeRepository.save(officeModel);
    }

    @Override
    public OfficeResponse find(String name) throws ContextNullException {
        var office = officeRepository.findByNomeAndCnpj(name, cnpj())
                .orElseThrow(() -> new EntityNotFoundException(String.format("O cargo %s não existe", name)));
        return new OfficeResponse(office);
    }

    @Override
    public List<OfficeResponse> list() throws ContextNullException {
        var office = officeRepository.findAllByCnpj(cnpj());
        List<OfficeResponse> response = office
                .stream()
                .map(OfficeResponse::new)
                .collect(Collectors.toList());
        return response;
    }

    @Transactional
    @Override
    public OfficeModel update(@Valid UUID id, OfficeCreate officeCreate) {
        var office = officeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Cargo com o id %s não foi encontrado", id)));
        BeanUtils.copyProperties(officeCreate, office, "id_cargo");
        return officeRepository.save(office);
    }

    @Transactional
    @Override
    public void delete(UUID id) {
        var office = officeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Cargo com o id %s não foi encontrado", id)));
        officeRepository.delete(office);
    }

    void valid(String nome) throws ContextNullException {
        if (officeRepository.existsByNomeAndCnpj(nome, cnpj()))
            throw new EntityAlreadyExistsException(String.format("O cargo %s já está cadastrado", nome));
    }

    public String cnpj() throws ContextNullException {
        return userSession.getSessionCnpj();
    }
}
