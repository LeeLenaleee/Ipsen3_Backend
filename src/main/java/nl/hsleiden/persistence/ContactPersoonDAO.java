package nl.hsleiden.persistence;

import com.google.inject.Inject;
import nl.hsleiden.model.ContactPersoonModel;
import org.hibernate.SessionFactory;

import javax.inject.Singleton;
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
        return super.findBy((criteriaBuilder, criteriaQuery, root) ->
                criteriaQuery.where(criteriaBuilder.like(root.get("contactBedrijf"), "%" + bedrijf + "%")));
    }

    public List<ContactPersoonModel> findByNaam(String voornaam, String achternaam) {
        return super.findBy((criteriaBuilder, criteriaQuery, root) ->
                criteriaQuery.where(criteriaBuilder.and(
                        criteriaBuilder.like(root.get("contactVoornaam"), "%" + voornaam + "%"),
                        criteriaBuilder.like(root.get("contactAchternaam"), "%" + achternaam + "%")
                )));
    }
}
