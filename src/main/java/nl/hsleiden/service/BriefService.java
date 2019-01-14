package nl.hsleiden.service;

import nl.hsleiden.model.BriefModel;
import nl.hsleiden.persistence.BriefDAO;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class BriefService extends CrudServiceImpl<BriefModel> {
    @Inject
    public BriefService(BriefDAO dao) {
        super(dao);
    }
}
