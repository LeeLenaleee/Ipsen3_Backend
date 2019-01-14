package nl.hsleiden.persistence;

import nl.hsleiden.model.FactuurModel;
import org.hibernate.SessionFactory;

import javax.inject.Inject;

public class FactuurDAO extends CrudDAOImpl<FactuurModel> {
    @Inject
    public FactuurDAO(SessionFactory sessionFactory) {
        super(FactuurModel.class, sessionFactory);
    }

}
