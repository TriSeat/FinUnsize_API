package finunsize.finunsizeapi.business.service.address;

import finunsize.finunsizeapi.business.dto.address.AddressCreate;
import finunsize.finunsizeapi.business.dto.address.AddressUpdate;
import finunsize.finunsizeapi.persistence.model.address.AddressModel;

import java.util.UUID;

public interface AddressService {

    AddressModel create(AddressCreate addressCreate);
    AddressModel update(UUID id, AddressUpdate addressUpdate);
    void delete();

}
