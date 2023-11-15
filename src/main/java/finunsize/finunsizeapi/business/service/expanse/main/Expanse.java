package finunsize.finunsizeapi.business.service.expanse;

import finunsize.finunsizeapi.persistence.model.expanse.ExpanseModel;
import finunsize.finunsizeapi.persistence.repository.expanse.ExpanseRepository;

public class Expanse implements ExpanseService {

    private final ExpanseRepository expanseRepository;

    public Expanse (ExpanseRepository expanseRepository) {
        this.expanseRepository = expanseRepository;
    }

    @Override
    public ExpanseModel create(ExpanseModel expanseModel) {
        return null;
    }

    @Override
    public ExpanseModel update(ExpanseModel expanseModel) {
        return null;
    }

    @Override
    public void delete() {

    }
}
