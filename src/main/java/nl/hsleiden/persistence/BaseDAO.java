package nl.hsleiden.persistence;

import nl.hsleiden.model.BaseModel;
import nl.hsleiden.model.ContactPerson;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * BaseDAO is a simple implementation of the CRUD operations.
 * @author Kasper
 * @param <T>
 */
public class BaseDAO<T extends BaseModel> {
    private final Class<T> type;
    private final SessionFactory sessionFactory;

    public BaseDAO(Class<T> type, SessionFactory sessionFactory)
    {
        this.type = type;
        this.sessionFactory = sessionFactory;
    }

    protected Session currentSession()
    {
        return this.sessionFactory.getCurrentSession();
    }

    public T findById(int id)
    {
        return currentSession().get(type, id);
    }

    public void create(T obj)
    {
        currentSession().save(obj);
    }

    public void delete(T obj)
    {
        currentSession().delete(obj);
    }

    public void update(int id, T obj)
    {
        Session currentSession = currentSession();
        T old_obj = currentSession.load(type, id);

        currentSession.update(obj);
    }

    public List<T> findBy(TriFunction<CriteriaBuilder, CriteriaQuery<?>, Root<?>> lambda) {
        Session session = currentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(type);
        Root<T> root = criteriaQuery.from(type);

        lambda.apply(criteriaBuilder, criteriaQuery, root);

        Query<T> q = session.createQuery(criteriaQuery);

        return q.list();
    }

}