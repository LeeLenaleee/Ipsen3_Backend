package nl.hsleiden.persistence;

import nl.hsleiden.model.OfferteModel;
import org.hibernate.SessionFactory;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;

@Singleton
public class OfferteDAO extends BaseDAO<OfferteModel> {

    @Inject
    public OfferteDAO(SessionFactory factory) {
        super(OfferteModel.class, factory);
    }

    public List<OfferteModel> findByCorrespondentieNummer(int correspondentie) {
        System.err.println("wtf");
        return super.findBy((criteriaBuilder, criteriaQuery, root) ->
                criteriaQuery.where(criteriaBuilder.equal(root.get("correspondentienummer"), correspondentie)));
    }
}
