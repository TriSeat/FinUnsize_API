package finunsize.finunsizeapi.business.service.employee;

import finunsize.finunsizeapi.persistence.model.employee.OfficeModel;

public interface OfficeService {
    OfficeModel create(OfficeModel officeModel);
    OfficeModel update(OfficeModel officeModel);
    void delete();
}
