package nl.hsleiden.service;

import nl.hsleiden.model.OfferteModel;
import nl.hsleiden.persistence.OfferteDAO;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;

@Singleton
public class OfferteService extends BaseService<OfferteModel, OfferteDAO> {
    @Inject
    public OfferteService(OfferteDAO dao) {
        super(dao);
    }

    public List<OfferteModel> findByCorrespondentieNummer(int correspondentie) {
        return dao.findByCorrespondentieNummer(correspondentie);
    }
}