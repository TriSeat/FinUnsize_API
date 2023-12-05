package finunsize.finunsizeapi.business.service.supplier;

import finunsize.finunsizeapi.business.dto.product.supplier.SupplierCreate;
import finunsize.finunsizeapi.business.dto.product.supplier.SupplierResponse;
import finunsize.finunsizeapi.business.dto.product.supplier.SupplierUpdate;
import finunsize.finunsizeapi.persistence.model.product.SupplierModel;

import java.util.List;
import java.util.UUID;

public interface SupplierService {
    SupplierModel create(SupplierCreate supplierCreate);
    SupplierResponse find(String name);
    SupplierResponse findById(UUID id);
    List<SupplierResponse> list();
    SupplierModel update(UUID id, SupplierUpdate supplierUpdate);
    void delete(UUID id);
}