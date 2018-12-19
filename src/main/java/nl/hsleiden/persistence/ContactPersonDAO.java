package nl.hsleiden.persistence;

import com.google.inject.Inject;
import io.dropwizard.hibernate.AbstractDAO;
import nl.hsleiden.model.ContactPerson;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import javax.inject.Singleton;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.ws.rs.NotFoundException;
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
        List<ContactPerson> results = cr.list();

        if (results.isEmpty()) {
            throw new NotFoundException();
        }

        return results;
    }
}
