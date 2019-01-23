package nl.hsleiden.service;

import nl.hsleiden.model.BriefModel;
import nl.hsleiden.persistence.BriefDAO;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;

@Singleton
public class BriefService extends BaseService<BriefModel, BriefDAO> {
    @Inject
    public BriefService(BriefDAO dao) {
        super(dao);
    }

    public List<BriefModel> findByGeadreseerde(String geadreseerde) {
        return this.dao.findByGeadreseerde(geadreseerde);
    }
}
