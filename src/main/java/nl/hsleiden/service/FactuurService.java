package nl.hsleiden.service;

import nl.hsleiden.model.FactuurModel;
import nl.hsleiden.persistence.CrudDAOImpl;
import nl.hsleiden.persistence.FactuurDAO;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class FactuurService extends CrudServiceImpl<FactuurModel> {
    @Inject
    public FactuurService(FactuurDAO dao) {
        super(dao);
    }
}
