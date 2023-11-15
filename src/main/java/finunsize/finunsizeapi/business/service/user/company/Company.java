package finunsize.finunsizeapi.business.service.user.company;

import finunsize.finunsizeapi.business.dto.user.company.CompanyCreate;
import finunsize.finunsizeapi.business.dto.user.company.CompanyResponse;
import finunsize.finunsizeapi.business.dto.user.company.CompanyUpdate;
import finunsize.finunsizeapi.integration.auth.UserSession;
import finunsize.finunsizeapi.persistence.model.user.CompanyModel;
import finunsize.finunsizeapi.persistence.repository.user.CompanyRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Company implements CompanyService {
    private final CompanyRepository companyRepository;
    private final UserSession userSession;
    private final ValidationCompany validationCompany;

    @Autowired
    public Company(CompanyRepository companyRepository, UserSession userSession, ValidationCompany validationCompany) {
        this.companyRepository = companyRepository;
        this.userSession = userSession;
        this.validationCompany = validationCompany;
    }

    @Transactional
    @Override
    public CompanyModel create(@Valid CompanyCreate companyCreate) {
        CompanyModel companyModel = new CompanyModel();
        validationCompany.valid(companyCreate.cnpj(), companyCreate.nome(), companyCreate.segmento(), companyCreate.razao());
        BeanUtils.copyProperties(companyCreate, companyModel);
        return companyRepository.save(companyModel);
    }

    @Override
    public CompanyResponse find() {
        var cnpj = getCnpj();
        var company = companyRepository.findByCnpj(cnpj)
                .orElseThrow(() -> new RuntimeException("Empresa não encontrada ou excluída"));
        return new CompanyResponse(company);
    }

    @Transactional
    @Override
    public CompanyModel update(@Valid CompanyUpdate companyUpdate) {
        var cnpj = getCnpj();
        var company = companyRepository.findByCnpj(cnpj)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Empresa com o cnpj de %s não contém um cadastro", cnpj)));
        validationCompany.validUpdate(companyUpdate.nome(), companyUpdate.segmento(), cnpj, companyUpdate.razao_social());
        BeanUtils.copyProperties(companyUpdate, company, "cnpj");
        return companyRepository.save(company);
    }

    private String getCnpj() {
        String cnpj = userSession.getSessionCnpj();
        return cnpj;
    }
}