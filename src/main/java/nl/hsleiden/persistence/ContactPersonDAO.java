package nl.hsleiden.persistence;

import com.google.inject.Inject;
import nl.hsleiden.model.ContactPerson;
import org.hibernate.SessionFactory;

import javax.inject.Singleton;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
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

        TriFunction<CriteriaBuilder, CriteriaQuery<?>, Root<?>> anon = new TriFunction<CriteriaBuilder, CriteriaQuery<?>, Root<?>>() {
            @Override
            public void apply(CriteriaBuilder criteriaBuilder, CriteriaQuery<?> criteriaQuery, Root<?> root) {
                criteriaQuery.where(criteriaBuilder.like(root.get("contact_bedrijf"), "%" + bedrijf + "%"));
            }
        };

        return super.findBy(anon);
    }
}
