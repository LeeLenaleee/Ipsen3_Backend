package nl.hsleiden.persistence;

import com.google.inject.Inject;
import nl.hsleiden.model.ContactPerson;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
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

    public List<ContactPerson> findByBedrijf(String bedrijf) {
        Session currentSession = super.currentSession();
        Criteria cr = currentSession.createCriteria(ContactPerson.class);
        cr.add(Restrictions.ilike("contact_bedrijf", "%" + bedrijf + "%"));
        return cr.list();
    }
}
