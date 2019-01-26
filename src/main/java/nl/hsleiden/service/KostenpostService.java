package nl.hsleiden.service;

import com.google.inject.Inject;
import nl.hsleiden.model.KostenpostModel;
import nl.hsleiden.persistence.KostenpostDAO;

import java.util.List;

public class KostenpostService extends BaseService<KostenpostModel, KostenpostDAO> {
    @Inject
    public KostenpostService(KostenpostDAO dao) {
        super(dao);
    }

    public List<KostenpostModel> findByName(String name) {
        return dao.findByName(name);
    }
}
