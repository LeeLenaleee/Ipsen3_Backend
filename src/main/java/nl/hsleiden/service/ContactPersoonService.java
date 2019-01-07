package nl.hsleiden.service;

import nl.hsleiden.model.ContactPersoonModel;
import nl.hsleiden.persistence.ContactPersoonDAO;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;

@Singleton
public class ContactPersoonService extends BaseService<ContactPersoonModel, ContactPersoonDAO> {

    @Inject
    public ContactPersoonService(ContactPersoonDAO dao)
    {
        super(dao);
    }

    public List<ContactPersoonModel> findByBedrijf(String bedrijf) {
        return dao.findByBedrijf(bedrijf);
    }
}
