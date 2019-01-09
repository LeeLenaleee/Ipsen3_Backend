package nl.hsleiden.service;

import nl.hsleiden.model.FactuurModel;
import nl.hsleiden.persistence.FactuurDAO;
import nl.hsleiden.utility.PDFWriter;

import javax.inject.Inject;
import java.io.File;
import java.util.Optional;
import javax.inject.Singleton;

@Singleton
public class FactuurService extends BaseService<FactuurModel, FactuurDAO> {

    @Inject
    public FactuurService(FactuurDAO dao)
    {
        super(dao);
    }

    public File getById(int factuurId) {
        FactuurModel factuurModel = factuurDAO.getByFactuurId(factuurId).get();
        return PDFWriter.maakFactuur(factuurModel);
    }
  
    public void update(FactuurModel user, int userId) {
        user.setId(userId);
        super.update(user);
    }
}
