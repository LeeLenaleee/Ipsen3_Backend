package nl.hsleiden.service;

import nl.hsleiden.model.OfferteModel;
import nl.hsleiden.persistence.OfferteDAO;
import nl.hsleiden.utility.PDFWriter;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.NotFoundException;
import java.io.File;
import java.util.Optional;

@Singleton
public class OfferteService {
    OfferteDAO offerteDAO;

    @Inject
    public OfferteService(OfferteDAO dao){this.offerteDAO = dao;}

    public File getById(int offerteId) {
        Optional<OfferteModel> offerte = offerteDAO.getByOfferteId(offerteId);
        if(offerte.isPresent()){
            return PDFWriter.maakOfferte(offerte.get());
        }else throw new NotFoundException("Not found");
    }
}