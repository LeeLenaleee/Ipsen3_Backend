package nl.hsleiden.persistence;

import nl.hsleiden.model.OfferteModel;
import nl.hsleiden.model.TelefoonnummerModel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.Optional;

@Singleton
public class OfferteDAO extends BaseDAO<OfferteModel> {

    @Inject
    public OfferteDAO(SessionFactory factory) { super(OfferteModel.class, factory); }

    public Optional<OfferteModel> getByOfferteId(int factuurId) {
        Session session = currentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<OfferteModel> criteriaQuery = criteriaBuilder.createQuery(OfferteModel.class);
        Root<OfferteModel> root = criteriaQuery.from(OfferteModel.class);
        criteriaQuery.where(criteriaBuilder.and(criteriaBuilder.equal(root.get("id"), factuurId)));

        Query<OfferteModel> q = session.createQuery(criteriaQuery);
        return q.uniqueResultOptional();
    }
}
