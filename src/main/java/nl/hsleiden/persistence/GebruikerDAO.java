package nl.hsleiden.persistence;

import com.google.inject.Inject;
import nl.hsleiden.model.GebruikerModel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import javax.inject.Singleton;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.Optional;

/**
 * @author Jacco van den Berg
 */
@Singleton
public class GebruikerDAO extends BaseDAO<GebruikerModel> {
    @Inject
    public GebruikerDAO(SessionFactory factory) {
        super(GebruikerModel.class, factory);
    }

    public Optional<GebruikerModel> getByCredentials(String username, String password) {
        Session session = currentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<GebruikerModel> criteriaQuery = criteriaBuilder.createQuery(GebruikerModel.class);
        Root<GebruikerModel> root = criteriaQuery.from(GebruikerModel.class);

        criteriaQuery.where(criteriaBuilder.and(
                criteriaBuilder.equal(root.get("emailAdres"), username),
                criteriaBuilder.equal(root.get("wachtwoord"), password)
        ));

        Query<GebruikerModel> q = session.createQuery(criteriaQuery);

        return q.uniqueResultOptional();
    }
}