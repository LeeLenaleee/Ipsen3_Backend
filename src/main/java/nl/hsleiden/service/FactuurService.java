package nl.hsleiden.service;

import nl.hsleiden.model.FactuurModel;
import nl.hsleiden.persistence.FactuurDAO;

import javax.inject.Inject;
import java.util.Optional;

public class FactuurService {
    FactuurDAO factuurDAO;
    FactuurModel factuur;

    @Inject
    public FactuurService(FactuurDAO dao){this.factuurDAO = dao;}

    public Optional<FactuurModel> getById(int factuurId) throws Exception {
        factuur = factuurDAO.getByFactuurId(factuurId).orElseThrow(() -> new Exception());
        return null;
    }
}
