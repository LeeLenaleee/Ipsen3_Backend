package nl.hsleiden.persistence;

import nl.hsleiden.model.BtwPercentageModel;
import org.hibernate.SessionFactory;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class BtwPercentageDAO extends BaseDAO<BtwPercentageModel> {

    @Inject
    public BtwPercentageDAO(SessionFactory factory) { super(BtwPercentageModel.class, factory); }
}
