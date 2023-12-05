package finunsize.finunsizeapi.business.service.address;

import finunsize.finunsizeapi.business.dto.address.AddressCreate;
import finunsize.finunsizeapi.business.dto.address.AddressUpdate;
import finunsize.finunsizeapi.persistence.model.address.AddressModel;
import finunsize.finunsizeapi.persistence.repository.address.AddressRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class Address implements AddressService {
    private final AddressRepository addressRepository;

    public Address (AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }


    @Override
    public AddressModel create(@Valid AddressCreate addressCreate) {
        var addressModel = new AddressModel();
        BeanUtils.copyProperties(addressCreate, addressModel, "id_logradouro");
        return addressRepository.save(addressModel);
    }

    @Override
    public AddressModel update(UUID id, @Valid AddressUpdate addressUpdate) {
        var address = addressRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Endereço não foi encontrado: %s", id)));
        BeanUtils.copyProperties(addressUpdate, address, "id_logradouro");
        return addressRepository.save(address);
    }

    @Override
    public void delete() {}
}
