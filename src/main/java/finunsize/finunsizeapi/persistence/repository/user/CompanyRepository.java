package finunsize.finunsizeapi.persistence.repository.user;

import finunsize.finunsizeapi.persistence.model.user.CompanyModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository <CompanyModel, String> {
    CompanyModel findByCnpj(String cnpj);
}
