package nl.hsleiden.persistence;

import nl.hsleiden.model.BaseModel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

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
}