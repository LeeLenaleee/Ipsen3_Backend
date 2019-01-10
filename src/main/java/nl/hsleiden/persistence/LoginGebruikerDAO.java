package nl.hsleiden.persistence;

import java.util.List;
import java.util.Optional;
import javax.inject.Singleton;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.google.inject.Inject;
import nl.hsleiden.model.GebruikerModel;
import nl.hsleiden.model.LoginGebruikerModel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

/**
 *
 * @author Jacco van den Berg
 */
@Singleton
public class LoginGebruikerDAO extends BaseDAO<GebruikerModel>
{
    @Inject
    public LoginGebruikerDAO(SessionFactory factory) {
        super(GebruikerModel.class, factory);
    }

    public Optional<GebruikerModel> getByEmailAddress(LoginGebruikerModel loginGebruikerModel) {

        Session session = currentSession();
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<GebruikerModel> criteriaQuery = criteriaBuilder.createQuery(GebruikerModel.class);
        Root<GebruikerModel> root = criteriaQuery.from(GebruikerModel.class);

        criteriaQuery.where(criteriaBuilder.and(criteriaBuilder.equal(root.get("email_adres"), loginGebruikerModel.getEmail()), criteriaBuilder.equal(root.get("password"), loginGebruikerModel.getPassword())));

        Query<GebruikerModel> q = session.createQuery(criteriaQuery);

        return q.uniqueResultOptional();
    }
}