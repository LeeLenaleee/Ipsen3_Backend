package nl.hsleiden.persistence;

import com.google.inject.Inject;
import nl.hsleiden.model.GebruikerModel;
import org.hibernate.SessionFactory;

import javax.inject.Singleton;
import java.util.Optional;

/**
 * @author Jacco van den Berg
 */
@Singleton
public class GebruikerDAO extends CrudFindableDAOimpl<GebruikerModel> {
    @Inject
    public GebruikerDAO(SessionFactory factory) {
        super(GebruikerModel.class, factory);
    }

    public Optional<GebruikerModel> getByCredentials(String username, String password) {
        return super.findBy((criteriaBuilder, criteriaQuery, root) -> criteriaQuery.where(criteriaBuilder.and(
                criteriaBuilder.equal(root.get("emailAdres"), username),
                criteriaBuilder.equal(root.get("wachtwoord"), password)
        )), query -> query.uniqueResultOptional());
    }
}