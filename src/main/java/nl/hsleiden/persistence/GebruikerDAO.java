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
public class GebruikerDAO extends BaseDAO<GebruikerModel> {
    Finder<GebruikerModel, GebruikerDAO> finder;

    @Inject
    public GebruikerDAO(SessionFactory factory) {
        super(GebruikerModel.class, factory);
        this.finder = new Finder(GebruikerModel.class, this);
    }

    public Optional<GebruikerModel> getByCredentials(String username, String password) {
        return this.finder.findBy((criteriaBuilder, criteriaQuery, root) -> criteriaQuery.where(criteriaBuilder.and(
                criteriaBuilder.equal(root.get("emailAdres"), username),
                criteriaBuilder.equal(root.get("wachtwoord"), password)
        )), query -> query.uniqueResultOptional());
    }
}