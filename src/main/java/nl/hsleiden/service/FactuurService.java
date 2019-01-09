package nl.hsleiden.service;

import nl.hsleiden.model.FactuurModel;
import nl.hsleiden.persistence.FactuurDAO;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class FactuurService extends BaseService<FactuurModel, FactuurDAO> {

    @Inject
    public FactuurService(FactuurDAO dao)
    {
        super(dao);
    }

    public Optional<FactuurModel> getById(int factuurId) throws Exception {
        factuur = factuurDAO.getByFactuurId(factuurId).orElseThrow(() -> new Exception());
        return null;
    }
    public void update(FactuurModel user, int userId) {
        user.setId(userId);
        super.update(user);
    }
}
