package finunsize.finunsizeapi.business.service.user.company;

import finunsize.finunsizeapi.business.dto.user.company.CompanyCreate;
import finunsize.finunsizeapi.business.dto.user.company.CompanyResponse;
import finunsize.finunsizeapi.business.dto.user.company.CompanyUpdate;
import finunsize.finunsizeapi.persistence.model.user.CompanyModel;

public interface CompanyService {
    CompanyModel create(CompanyCreate companyCreate);
    CompanyResponse find();
    CompanyModel update(CompanyUpdate companyUpdate);
}
