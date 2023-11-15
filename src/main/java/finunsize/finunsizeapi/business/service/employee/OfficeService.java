package finunsize.finunsizeapi.business.service.employee;

import finunsize.finunsizeapi.business.dto.employee.office.OfficeCreate;
import finunsize.finunsizeapi.business.dto.employee.office.OfficeResponse;
import finunsize.finunsizeapi.persistence.model.employee.OfficeModel;

import java.util.List;
import java.util.UUID;

public interface OfficeService {
    OfficeModel create(OfficeCreate officeCreate);
    OfficeResponse find(String name);
    List<OfficeResponse> list();
    OfficeModel update(UUID id, OfficeCreate officeCreate);
    void delete(UUID id);
}
