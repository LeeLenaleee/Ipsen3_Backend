package nl.hsleiden.persistence;

import com.google.inject.Inject;
import nl.hsleiden.model.ContactPersoonModel;
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
public class ContactPersoonDAO extends BaseDAO<ContactPersoonModel> {

    @Inject
    public ContactPersoonDAO(SessionFactory factory) {
        super(ContactPersoonModel.class, factory);
    }

    public List<ContactPersoonModel> findByBedrijf(String bedrijf) {

        TriFunction<CriteriaBuilder, CriteriaQuery<?>, Root<?>> anon = new TriFunction<CriteriaBuilder, CriteriaQuery<?>, Root<?>>() {
            @Override
            public void apply(CriteriaBuilder criteriaBuilder, CriteriaQuery<?> criteriaQuery, Root<?> root) {
                criteriaQuery.where(criteriaBuilder.like(root.get("contactBedrijf"), "%" + bedrijf + "%"));
            }
        };

        return super.findBy(anon);
    }

    public List<ContactPersoonModel> findByNaam(String voornaam, String achternaam) {
        TriFunction<CriteriaBuilder, CriteriaQuery<?>, Root<?>> anon = new TriFunction<CriteriaBuilder, CriteriaQuery<?>, Root<?>>() {
            @Override
            public void apply(CriteriaBuilder criteriaBuilder, CriteriaQuery<?> criteriaQuery, Root<?> root) {
                criteriaQuery.where(criteriaBuilder.and(
                        criteriaBuilder.like(root.get("contactVoornaam"), "%" + voornaam + "%"),
                        criteriaBuilder.like(root.get("contactAchternaam"), "%" + achternaam + "%")
                ));
            }
        };

        return super.findBy(anon);
    }
}
