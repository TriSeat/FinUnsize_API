package finunsize.finunsizeapi.persistence.repository.expanse;

import finunsize.finunsizeapi.persistence.model.expanse.ExpanseModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ExpanseRepository extends JpaRepository <ExpanseModel, UUID> {
}
