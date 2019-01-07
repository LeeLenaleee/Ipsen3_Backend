package nl.hsleiden.service;

import nl.hsleiden.model.GebruikerModel;
import nl.hsleiden.persistence.GebruikerDAO;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class GebruikerService extends BaseService<GebruikerModel, GebruikerDAO> {

    @Inject
    public GebruikerService(GebruikerDAO dao)
    {
        super(dao);
    }

    public void update(GebruikerModel user, int userId) {
        user.setId(userId);
        super.update(user);
    }
}
