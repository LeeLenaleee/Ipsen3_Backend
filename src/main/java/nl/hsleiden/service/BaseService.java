package nl.hsleiden.service;

import javax.ws.rs.ForbiddenException;
import javax.ws.rs.NotFoundException;

import com.google.inject.Inject;
import nl.hsleiden.model.BaseModel;
import nl.hsleiden.persistence.BaseDAO;

import java.util.List;

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

    public List<M> findAll()
    {
        return dao.findAll();
    }

    public void create(M obj)
    {
        dao.create(obj);
    }

    public void delete(M obj)
    {
        dao.delete(obj);
    }

    public void update(M obj)
    {
        dao.update(obj);
    }
}
