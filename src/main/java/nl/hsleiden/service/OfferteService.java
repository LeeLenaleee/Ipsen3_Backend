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
public class OfferteService extends BaseService<OfferteModel,OfferteDAO>{
    @Inject
    public OfferteService(OfferteDAO dao) {
        super(dao);
    }
}