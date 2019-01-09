package nl.hsleiden.service;

import nl.hsleiden.utility.PDFWriter;
import nl.hsleiden.model.FactuurModel;
import nl.hsleiden.persistence.FactuurDAO;

import javax.inject.Inject;
import javax.ws.rs.NotFoundException;
import java.io.File;
import java.util.Optional;

public class FactuurService {
    FactuurDAO factuurDAO;

    @Inject
    public FactuurService(FactuurDAO dao){this.factuurDAO = dao;}

    public File getById(int factuurId) {
        Optional<FactuurModel> factuur = factuurDAO.getByFactuurId(factuurId);
        if(factuur.isPresent()){
            return PDFWriter.maakFactuur(factuur.get());
        }else throw new NotFoundException("Not found");
    }
}
