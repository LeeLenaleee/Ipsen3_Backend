package nl.hsleiden.service;

import nl.hsleiden.utility.PDFWriter;
import nl.hsleiden.model.FactuurModel;
import nl.hsleiden.persistence.FactuurDAO;

import javax.inject.Inject;
import java.io.File;
import java.util.Optional;


public class FactuurService {
    FactuurDAO factuurDAO;
    FactuurModel factuur;

    @Inject
    public FactuurService(FactuurDAO dao){this.factuurDAO = dao;}

    public File getById(int factuurId) {
        FactuurModel factuurModel = factuurDAO.getByFactuurId(factuurId).get();
        return PDFWriter.maakFactuur(factuurModel);
    }
}
