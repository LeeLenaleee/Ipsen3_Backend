package nl.hsleiden.persistence;

import nl.hsleiden.model.BriefModel;
import org.hibernate.SessionFactory;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;

@Singleton
public class BriefDAO extends BaseDAO<BriefModel> {
    @Inject
    public BriefDAO(SessionFactory sessionFactory) {
        super(BriefModel.class, sessionFactory);
    }

    public List<BriefModel> findByGeadreseerde(String geadreseerde) {
        return super.findBy((criteriaBuilder, criteriaQuery, root) ->
                criteriaQuery.where(criteriaBuilder.like(root.get("betreft"), "%" + geadreseerde + "%")));
    }
}
