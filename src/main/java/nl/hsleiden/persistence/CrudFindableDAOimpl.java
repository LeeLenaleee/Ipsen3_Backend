package nl.hsleiden.persistence;

import com.google.inject.Inject;
import nl.hsleiden.model.BaseModel;
import org.hibernate.SessionFactory;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class CrudFindableDAOimpl<T extends BaseModel> extends FindableDAOImpl<T> implements CrudDAO<T> {

    @Inject
    public CrudFindableDAOimpl(Class<T> type, SessionFactory factory) {
        super(type, factory);
    }

    public T findById(int id) {
        return currentSession().get(type, id);
    }

    public List<T> findAll() {
        CriteriaBuilder criteriaBuilder = currentSession().getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(type);
        criteriaQuery.from(type);
        return currentSession().createQuery(criteriaQuery).getResultList();

    }

    public void create(T obj) {
        currentSession().save(obj);
    }

    public void delete(T obj) {
        currentSession().delete(obj);
    }

    public void update(T obj) {
        currentSession().update(obj);
    }
}
