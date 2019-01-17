package nl.hsleiden.service;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import nl.hsleiden.model.KostenpostModel;
import nl.hsleiden.persistence.KostenPostDAO;

import java.util.List;

@Singleton
public class KostenPostService extends CrudFindableServiceImpl<KostenpostModel, KostenPostDAO> {
    @Inject
    public KostenPostService(KostenPostDAO dao) {
        super(dao);
    }

    public List<KostenpostModel> findByName(String name) {
        return dao.findByName(name);
    }
}
