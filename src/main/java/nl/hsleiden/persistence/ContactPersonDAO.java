package nl.hsleiden.persistence;

import com.google.inject.Inject;
import io.dropwizard.hibernate.AbstractDAO;
import nl.hsleiden.model.ContactPerson;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.inject.Singleton;
import java.util.List;

/**
 * @author Kasper
 */
@Singleton
public class ContactPersonDAO extends BaseDAO<ContactPerson> {

    @Inject
    public ContactPersonDAO(SessionFactory factory) {
        super(ContactPerson.class, factory);
    }
}
