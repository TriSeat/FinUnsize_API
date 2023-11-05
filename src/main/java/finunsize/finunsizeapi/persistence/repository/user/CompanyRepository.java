package finunsize.finunsizeapi.persistence.repository.user;

import finunsize.finunsizeapi.business.dto.user.company.CompanyResponse;
import finunsize.finunsizeapi.persistence.model.user.CompanyModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CompanyRepository extends JpaRepository <CompanyModel, String> {
    CompanyModel findCnpjByCnpj(String cnpj);
    Optional<CompanyModel> findByCnpj(String cnpj);
    boolean existsByCnpj(String cnpj);
    boolean existsByNomeAndSegmento(String name, String Segmento);
    boolean existsByNomeAndSegmentoAndCnpjNot(String name, String Segmento, String cnpj);
    boolean existsByRazao(String corporate_reason);
    boolean existsByRazaoAndCnpjNot(String corporate_reason, String cnpj);
}