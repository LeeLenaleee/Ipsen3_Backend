package nl.hsleiden.persistence;

import nl.hsleiden.model.FactuurModel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import javax.inject.Inject;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.Optional;

public class FactuurDAO extends BaseDAO<FactuurModel> {
    @Inject
    public FactuurDAO(SessionFactory sessionFactory) {
        super(FactuurModel.class, sessionFactory);
    }

    public Optional<FactuurModel> getByFactuurId(int factuurId) {
        Session session = currentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<FactuurModel> criteriaQuery = criteriaBuilder.createQuery(FactuurModel.class);
        Root<FactuurModel> root = criteriaQuery.from(FactuurModel.class);
        criteriaQuery.where(criteriaBuilder.and(criteriaBuilder.equal(root.get("id"), factuurId)));

        Query<FactuurModel> q = session.createQuery(criteriaQuery);
        System.err.println(q.uniqueResultOptional().get().getFactuur_omschrijving());
        return q.uniqueResultOptional();
    }
}
