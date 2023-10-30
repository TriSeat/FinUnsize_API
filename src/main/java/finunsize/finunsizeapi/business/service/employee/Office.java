package finunsize.finunsizeapi.business.service.employee;

import finunsize.finunsizeapi.persistence.repository.employee.OfficeRepository;

public class Office implements OfficeService {

    private final OfficeRepository officeRepository;

    public Office (OfficeRepository officeRepository) {
        this.officeRepository = officeRepository;
    }

}
