package finunsize.finunsizeapi.business.service.expanse;

import finunsize.finunsizeapi.persistence.repository.expanse.ExpanseRepository;

public class Expanse implements ExpanseService {

    private final ExpanseRepository expanseRepository;

    public Expanse (ExpanseRepository expanseRepository) {
        this.expanseRepository = expanseRepository;
    }

}
