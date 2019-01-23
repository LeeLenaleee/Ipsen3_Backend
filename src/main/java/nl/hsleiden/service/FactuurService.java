package nl.hsleiden.service;

import nl.hsleiden.model.FactuurModel;
import nl.hsleiden.persistence.FactuurDAO;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;

@Singleton
public class FactuurService extends BaseService<FactuurModel, FactuurDAO> {
    @Inject
    public FactuurService(FactuurDAO dao) {
        super(dao);
    }

    public List<FactuurModel> findByOmschrijving(String omschrijving) {
        return this.dao.findByOmschrijving(omschrijving);
    }
}
