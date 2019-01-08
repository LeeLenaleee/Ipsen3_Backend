package nl.hsleiden.persistence;

import com.google.inject.Inject;
import nl.hsleiden.model.OnkostenModel;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import javax.inject.Singleton;
import javax.ws.rs.NotFoundException;
import java.util.List;

/**
 * @author Simon van Kouteren
 */
@Singleton
public class OnkostenDAO extends BaseDAO<OnkostenModel> {

    @Inject
    public OnkostenDAO(SessionFactory factory) {
        super(OnkostenModel.class, factory);
    }

    public List<OnkostenModel> findByOmschrijving(String omschrijving) {
        Session currentSession = super.currentSession();
        Criteria cr = currentSession.createCriteria(OnkostenModel.class);
        cr.add(Restrictions.ilike("onkosten_omschrijving", "%" + omschrijving + "%"));
        List<OnkostenModel> results = cr.list();
        if (results.isEmpty()) {
            throw new NotFoundException();
        }

        return results;
    }
}
