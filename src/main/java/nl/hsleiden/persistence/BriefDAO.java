package nl.hsleiden.persistence;

import nl.hsleiden.model.BriefModel;
import org.hibernate.SessionFactory;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class BriefDAO extends CrudDAOImpl<BriefModel> {
    @Inject
    public BriefDAO(SessionFactory sessionFactory) {
        super(BriefModel.class, sessionFactory);
    }
}
