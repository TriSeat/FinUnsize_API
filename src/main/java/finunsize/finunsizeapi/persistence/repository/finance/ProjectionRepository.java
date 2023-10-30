package finunsize.finunsizeapi.persistence.repository.finance;

import finunsize.finunsizeapi.persistence.model.finance.ProjectionModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProjectionRepository extends JpaRepository <ProjectionModel, UUID> {
}
