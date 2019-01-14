package nl.hsleiden.persistence;

import nl.hsleiden.model.BaseModel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class FindableDAOImpl<T extends BaseModel> implements FindableDAO<T> {

    protected Class<T> type;
    protected SessionFactory sessionFactory;

    public FindableDAOImpl(Class<T> type, SessionFactory factory) {
        this.type = type;
        this.sessionFactory = factory;
    }

    public Session currentSession() {
        return this.sessionFactory.getCurrentSession();
    }

    public <R> R findBy(TriFunction<CriteriaBuilder, CriteriaQuery<?>, Root<?>> buildQuery, QueryExtractor<T, R> extractor) {
        Session session = currentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(type);
        Root<T> root = criteriaQuery.from(type);

        buildQuery.apply(criteriaBuilder, criteriaQuery, root);

        Query<T> q = session.createQuery(criteriaQuery);

        return extractor.extract(q);
    }
}
