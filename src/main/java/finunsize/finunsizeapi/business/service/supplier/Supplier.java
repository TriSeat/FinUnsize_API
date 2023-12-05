package finunsize.finunsizeapi.business.service.supplier;

import finunsize.finunsizeapi.business.configuration.handler.EntityAlreadyExistsException;
import finunsize.finunsizeapi.business.dto.product.supplier.SupplierCreate;
import finunsize.finunsizeapi.business.dto.product.supplier.SupplierResponse;
import finunsize.finunsizeapi.business.dto.product.supplier.SupplierUpdate;
import finunsize.finunsizeapi.business.service.address.AddressService;
import finunsize.finunsizeapi.integration.auth.UserSession;
import finunsize.finunsizeapi.persistence.model.address.AddressModel;
import finunsize.finunsizeapi.persistence.model.product.SupplierModel;
import finunsize.finunsizeapi.persistence.repository.product.SupplierRepository;
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
public class Supplier implements SupplierService {

    private final SupplierRepository supplierRepository;
    private final AddressService addressService;
    private final UserSession userSession;

    @Autowired
    public Supplier(SupplierRepository supplierRepository, AddressService addressService, UserSession userSession) {
        this.supplierRepository = supplierRepository;
        this.addressService = addressService;
        this.userSession = userSession;
    }


    @Transactional
    @Override
    public SupplierModel create(SupplierCreate supplierCreate) {
        var supplierModel = new SupplierModel();
        valid(supplierCreate.nome(), userSession.getSessionCnpj());
        BeanUtils.copyProperties(supplierCreate, supplierModel, "idFornecedor");
        var address = addressService.create(supplierCreate.endereco());
        insertFk(supplierModel, address);
        return  supplierRepository.save(supplierModel);
    }

    @Override
    public SupplierResponse find(String name) {
        var supplier = supplierRepository.findByNomeAndCnpj(name, userSession.getSessionCnpj())
                .orElseThrow(() -> new EntityNotFoundException(String.format("Fornecedor com o nome %s não foi encontrado", name)));
        return new SupplierResponse(supplier);
    }

    @Override
    public SupplierResponse findById(UUID id) {
        var supplier = supplierRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Fornecedor com o id %s não foi encontrado", id)));
        return new SupplierResponse(supplier);
    }

    @Override
    public List<SupplierResponse> list() {
        List<SupplierModel> supplierModel = supplierRepository.findByCnpj(userSession.getSessionCnpj());
        List<SupplierResponse> response = supplierModel
                .stream()
                .map(SupplierResponse::new)
                .collect(Collectors.toList());
        return response;
    }

    @Transactional
    @Override
    public SupplierModel update(UUID id, @Valid SupplierUpdate supplierUpdate) {
        var supplier = supplierRepository.findByIdFornecedorAndCnpj(id, userSession.getSessionCnpj())
                .orElseThrow(() -> new EntityNotFoundException(String.format("Fornecdor com o nome de: %s não foi encontrado", id.toString())));
        BeanUtils.copyProperties(supplierUpdate, supplier, "idFornecedor");
        addressService.update(supplier.getId_endereco().getId_logradouro(), supplierUpdate.endereco());
        addressService.update(supplier.getId_endereco().getId_logradouro(), supplierUpdate.endereco());
        return supplierRepository.save(supplier);
    }

    @Override
    public void delete(UUID id) {
        var supplier = supplierRepository.findByIdFornecedorAndCnpj(id, userSession.getSessionCnpj())
                        .orElseThrow(() -> new EntityNotFoundException(String.format("Fornecedor com o id de: %s não foi encontrado", id.toString())));
        supplierRepository.delete(supplier);
    }

    private void insertFk(SupplierModel supplierModel, AddressModel addressModel) {
        supplierModel.setId_endereco(addressModel);
        supplierModel.setCnpj(userSession.getSessionCnpj());
    }

    private void valid(String name, String cnpj) {
        if(supplierRepository.existsByNomeAndCnpj(name, cnpj))
            throw new EntityAlreadyExistsException(String.format("O Nome %s já está cadastrado", name));
    }
}
