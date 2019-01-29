package nl.hsleiden.persistence;

import com.google.inject.Inject;
import nl.hsleiden.model.ContactPersoonModel;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import javax.inject.Singleton;
import java.util.List;

/**
 * @author Kasper
 */
@Singleton
public class ContactPersoonDAO extends BaseDAO<ContactPersoonModel> {
    Finder<ContactPersoonModel, ContactPersoonDAO> finder;

    @Inject
    public ContactPersoonDAO(SessionFactory factory) {

        super(ContactPersoonModel.class, factory);
        this.finder = new Finder(ContactPersoonModel.class, this);
    }

    public List<ContactPersoonModel> findByBedrijf(String bedrijf) {
        return this.finder.findBy(
                (criteriaBuilder, criteriaQuery, root) ->
                        criteriaQuery.where(criteriaBuilder.like(root.get("contactBedrijf"), "%" + bedrijf + "%")),
                Query::list
        );
    }

    public List<ContactPersoonModel> findByNaam(String voornaam, String achternaam) {
        return this.finder.findBy((criteriaBuilder, criteriaQuery, root) ->
                        criteriaQuery.where(criteriaBuilder.and(
                                criteriaBuilder.like(root.get("contactVoornaam"), "%" + voornaam + "%"),
                                criteriaBuilder.like(root.get("contactAchternaam"), "%" + achternaam + "%")
                        )),
                Query::list
        );
    }
}
