package nl.hsleiden.service;

import nl.hsleiden.model.ContactPersonModel;
import nl.hsleiden.persistence.ContactPersonDAO;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;

@Singleton
public class ContactPersonService extends BaseService<ContactPersonModel, ContactPersonDAO> {

    @Inject
    public ContactPersonService(ContactPersonDAO dao)
    {
        super(dao);
    }

    public List<ContactPersonModel> findByBedrijf(String bedrijf) {
        return dao.findByBedrijf(bedrijf);
    }
}
