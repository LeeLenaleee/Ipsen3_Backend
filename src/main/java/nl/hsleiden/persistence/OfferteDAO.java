package nl.hsleiden.persistence;

import nl.hsleiden.model.OfferteModel;
import org.hibernate.SessionFactory;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class OfferteDAO extends CrudDAOImpl<OfferteModel> {

    @Inject
    public OfferteDAO(SessionFactory factory) {
        super(OfferteModel.class, factory);
    }
}
