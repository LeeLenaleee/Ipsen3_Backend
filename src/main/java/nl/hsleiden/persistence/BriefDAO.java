package nl.hsleiden.persistence;

import nl.hsleiden.model.BriefModel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.Optional;

@Singleton
public class BriefDAO extends BaseDAO<BriefModel> {
    @Inject
    public BriefDAO(SessionFactory sessionFactory) {
        super(BriefModel.class, sessionFactory);
    }

    public Optional<BriefModel> getByBriefId(int briefId) {
        Session session = currentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<BriefModel> criteriaQuery = criteriaBuilder.createQuery(BriefModel.class);
        Root<BriefModel> root = criteriaQuery.from(BriefModel.class);
        criteriaQuery.where(criteriaBuilder.and(criteriaBuilder.equal(root.get("id"), briefId)));

        Query<BriefModel> q = session.createQuery(criteriaQuery);
        System.err.println(q.uniqueResultOptional().get().getVerhaal());
        return q.uniqueResultOptional();
    }
}
