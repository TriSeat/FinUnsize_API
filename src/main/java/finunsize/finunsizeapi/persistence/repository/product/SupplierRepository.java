package finunsize.finunsizeapi.persistence.repository.product;

import finunsize.finunsizeapi.persistence.model.product.SupplierModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface SupplierRepository extends JpaRepository<SupplierModel, UUID> {
    Optional<SupplierModel> findByNomeAndCnpj(String name, String cnpj);
    Optional<SupplierModel> findByIdFornecedorAndCnpj(UUID id, String cnpj);
    boolean existsByNomeAndCnpj(String name, String cnpj);
    List<SupplierModel> findByCnpj(String cnpj);
}
