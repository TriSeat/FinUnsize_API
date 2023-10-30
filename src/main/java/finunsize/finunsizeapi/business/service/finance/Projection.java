package finunsize.finunsizeapi.business.service.finance;

import finunsize.finunsizeapi.persistence.repository.finance.ProjectionRepository;

public class Projection implements ProjectionService {

    private final ProjectionRepository projectionRepository;

    public Projection (ProjectionRepository projectionRepository) {
        this.projectionRepository = projectionRepository;
    }

}
