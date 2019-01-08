package nl.hsleiden.service;
import nl.hsleiden.model.OnkostenModel;
import nl.hsleiden.persistence.OnkostenDAO;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;

/**
 * @author Simon van Kouteren
 */

@Singleton
public class OnkostenService extends BaseService<OnkostenModel, OnkostenDAO> {

    @Inject
    public OnkostenService(OnkostenDAO dao)
    {
        super(dao);
    }

    public List<OnkostenModel> findByOmschrijving(String omschrijving) {
        return dao.findByOmschrijving(omschrijving);
    }
}
