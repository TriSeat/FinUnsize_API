package finunsize.finunsizeapi.business.service.user.company;

import finunsize.finunsizeapi.business.configuration.handler.EntityAlreadyExistsException;
import finunsize.finunsizeapi.persistence.repository.user.CompanyRepository;
import org.springframework.stereotype.Component;

@Component
public class ValidationCompany {

    private final CompanyRepository companyRepository;

    public ValidationCompany(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public void valid(String cnpj, String name, String seg, String corporate_reason) {
        if (companyRepository.existsByCnpj(cnpj))
            throw new EntityAlreadyExistsException(String.format("O cnpj: %s já está cadastrado", cnpj));

        if (companyRepository.existsByNomeAndSegmento(name, seg))
            throw new EntityAlreadyExistsException(String.format("Empresa com o nome: %s e o segmento: %s já existem", name, seg));

        if(companyRepository.existsByRazao(corporate_reason))
            throw new EntityAlreadyExistsException(String.format("Não pode cadastrar razão social igual a de uma outra empresa: %s", corporate_reason));
    }

    public void validUpdate(String name, String seg, String cnpj, String corporate_reason) {

        if(companyRepository.existsByNomeAndSegmentoAndCnpjNot(name, seg, cnpj))
            throw new EntityAlreadyExistsException(String.format("Empresa com o nome: %s e o segmento: %s já existem", name, seg));

        if(companyRepository.existsByRazaoAndCnpjNot(corporate_reason, cnpj))
            throw new EntityAlreadyExistsException(String.format("A empresa não pode conter a mesma razão social de outra: %s", corporate_reason));
    }

}
