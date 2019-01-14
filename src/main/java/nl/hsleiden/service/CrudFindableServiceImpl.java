package nl.hsleiden.service;

import nl.hsleiden.model.BaseModel;
import nl.hsleiden.persistence.CrudFindableDAOimpl;

import javax.ws.rs.NotFoundException;
import java.util.List;

public class CrudFindableServiceImpl<M extends BaseModel, D extends CrudFindableDAOimpl<M>> implements CrudService<M> {
    protected D dao;

    public CrudFindableServiceImpl(D dao) {
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
