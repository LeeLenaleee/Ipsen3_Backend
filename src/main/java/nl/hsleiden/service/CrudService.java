package nl.hsleiden.service;

import nl.hsleiden.model.BaseModel;

import java.util.List;

public interface CrudService<M extends BaseModel> {
    public M findById(int id);

    public List<M> findAll();

    public void create(M obj);

    public void delete(M obj);

    public void update(M obj, int id);
}
