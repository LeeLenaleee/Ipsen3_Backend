package nl.hsleiden.service;

import nl.hsleiden.model.BtwPercentageModel;
import nl.hsleiden.persistence.BtwPercentageDAO;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class BtwPercentageService extends BaseService<BtwPercentageModel, BtwPercentageDAO> {

    @Inject
    public BtwPercentageService(BtwPercentageDAO dao) {
        super(dao);
    }
}
