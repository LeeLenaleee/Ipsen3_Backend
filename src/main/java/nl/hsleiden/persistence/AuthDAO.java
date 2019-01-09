package nl.hsleiden.persistence;

import java.util.Optional;
import javax.inject.Singleton;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.google.inject.Inject;
import io.dropwizard.auth.basic.BasicCredentials;
import nl.hsleiden.model.GebruikerModel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

/**
 *
 * @author Jacco van den Berg
 */
@Singleton
public class AuthDAO extends BaseDAO<GebruikerModel>
{
    @Inject
    public AuthDAO(SessionFactory factory) {
        super(GebruikerModel.class, factory);
    }

    public Optional<GebruikerModel> getByCredentials(BasicCredentials credentials) {

        Session session = currentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<GebruikerModel> criteriaQuery = criteriaBuilder.createQuery(GebruikerModel.class);
        Root<GebruikerModel> root = criteriaQuery.from(GebruikerModel.class);

        criteriaQuery.where(criteriaBuilder.and(
                criteriaBuilder.equal(root.get("emailAdres"), credentials.getUsername()),
                criteriaBuilder.equal(root.get("wachtwoord"), credentials.getPassword())
        ));

        Query<GebruikerModel> q = session.createQuery(criteriaQuery);

        return q.uniqueResultOptional();
    }
}