package nl.hsleiden.persistence;

import nl.hsleiden.model.OfferteModel;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;

@Singleton
public class OfferteDAO extends BaseDAO<OfferteModel> {
    Finder<OfferteModel, OfferteDAO> finder;

    @Inject
    public OfferteDAO(SessionFactory factory) {
        super(OfferteModel.class, factory);
        this.finder = new Finder(OfferteModel.class, this);
    }

    public List<OfferteModel> findByCorrespondentieNummer(int correspondentie) {
        return this.finder.findBy((criteriaBuilder, criteriaQuery, root) ->
                        criteriaQuery.where(criteriaBuilder.equal(root.get("correspondentienummer"), correspondentie)),
                Query::list
        );
    }
}
