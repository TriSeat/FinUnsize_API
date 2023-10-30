package finunsize.finunsizeapi.business.service.address;

import finunsize.finunsizeapi.persistence.repository.address.AddressRepository;
import org.springframework.stereotype.Service;

@Service
public class Address implements AddressService {
    private final AddressRepository addressRepository;

    public Address (AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }


}
