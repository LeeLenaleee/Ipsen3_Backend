package nl.hsleiden.service;

import javax.ws.rs.ForbiddenException;
import javax.ws.rs.NotFoundException;

import com.google.inject.Inject;
import nl.hsleiden.model.BaseModel;
import nl.hsleiden.persistence.BaseDAO;

/**
 *
 * @author Peter van Vliet, Kasper
 * @param <M>: Model
 * @Param <D>: Dao
 */
public class BaseService<M extends BaseModel, D extends BaseDAO<M>>
{
    protected D dao;

    @Inject
    public BaseService(D dao)
    {
        this.dao = dao;
    }

    public M requireResult(M model)
    {
        if (model == null)
        {
            throw new NotFoundException();
        }
        
        return model;
    }


    public M findById(int id)
    {
        return requireResult(dao.findById(id));
    }

    public void create(M obj)
    {
        dao.create(obj);
    }

    public void delete(M obj)
    {
        dao.delete(obj);
    }

    public void update(int id, M obj)
    {
        dao.update(id, obj);
    }
}
