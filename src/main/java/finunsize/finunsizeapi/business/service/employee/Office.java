package finunsize.finunsizeapi.business.service.employee;

import finunsize.finunsizeapi.persistence.model.employee.OfficeModel;
import finunsize.finunsizeapi.persistence.repository.employee.OfficeRepository;

public class Office implements OfficeService {

    private final OfficeRepository officeRepository;

    public Office (OfficeRepository officeRepository) {
        this.officeRepository = officeRepository;
    }

    @Override
    public OfficeModel create(OfficeModel officeModel) {
        return null;
    }

    @Override
    public OfficeModel update(OfficeModel officeModel) {
        return null;
    }

    @Override
    public void delete() {

    }
}
