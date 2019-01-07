package nl.hsleiden.persistence;

import nl.hsleiden.model.FactuurModel;
import org.hibernate.SessionFactory;

import javax.inject.Inject;

public class FactuurDAO extends BaseDAO<FactuurModel> {

    @Inject
    public FactuurDAO(SessionFactory factory) { super(FactuurModel.class, factory); }
}
