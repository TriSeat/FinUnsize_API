package finunsize.finunsizeapi.persistence.repository.expanse;

import finunsize.finunsizeapi.persistence.model.expanse.TypeExpanseModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TypeExpanseRepository extends JpaRepository <TypeExpanseModel, UUID> {
}
