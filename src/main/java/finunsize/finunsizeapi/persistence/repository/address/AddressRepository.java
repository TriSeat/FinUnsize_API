package finunsize.finunsizeapi.persistence.repository.address;

import finunsize.finunsizeapi.persistence.model.address.AddressModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AddressRepository extends JpaRepository <AddressModel, UUID> {


}
