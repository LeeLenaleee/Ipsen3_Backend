package nl.hsleiden.persistence;

import nl.hsleiden.model.BaseModel;

import java.util.List;

public interface CrudDAO<M extends BaseModel> extends BasicDAO<M> {
    public M findById(int id);

    public List<M> findAll();

    public void create(M obj);

    public void delete(M obj);

    public void update(M obj);
}
