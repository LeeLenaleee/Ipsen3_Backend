package nl.hsleiden.service;

import nl.hsleiden.model.GebruikerModel;
import nl.hsleiden.persistence.GebruikerDAO;

import javax.inject.Inject;
import java.util.Optional;

public class GebruikerService extends BaseService<GebruikerModel, GebruikerDAO> {
    @Inject
    public GebruikerService(GebruikerDAO dao) {
        super(dao);
    }

    public Optional<GebruikerModel> getByCredentials(String username, String wachtwoord) {
        return dao.getByCredentials(username, wachtwoord);
    }
}
