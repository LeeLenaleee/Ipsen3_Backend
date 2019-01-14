package nl.hsleiden.service;

import com.google.inject.Inject;
import nl.hsleiden.model.BaseModel;
import nl.hsleiden.persistence.CrudDAO;

import javax.ws.rs.NotFoundException;
import java.util.List;

public class CrudServiceImpl<M extends BaseModel> implements CrudService<M> {
    protected CrudDAO<M> dao;

    @Inject
    public CrudServiceImpl(CrudDAO<M> dao) {
        this.dao = dao;
    }

    public M requireResult(M model) {
        if (model == null) {
            throw new NotFoundException();
        }

        return model;
    }

    public M findById(int id) {
        return requireResult(dao.findById(id));
    }

    public List<M> findAll() {
        return dao.findAll();
    }

    public void create(M obj) {
        dao.create(obj);
    }

    public void delete(M obj) {
        dao.delete(obj);
    }

    public void update(M obj, int id) {
        obj.setId(id);
        dao.update(obj);
    }
}
