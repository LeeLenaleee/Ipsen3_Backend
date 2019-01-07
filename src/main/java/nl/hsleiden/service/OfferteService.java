package nl.hsleiden.service;

import nl.hsleiden.model.OfferteModel;
import nl.hsleiden.persistence.OfferteDAO;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class OfferteService extends BaseService<OfferteModel, OfferteDAO> {

    @Inject
    public OfferteService(OfferteDAO dao)
    {
        super(dao);
    }

    public void update(OfferteModel user, int userId) {
        user.setId(userId);
        super.update(user);
    }
}