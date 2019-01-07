package nl.hsleiden.service;

import nl.hsleiden.model.ContactPerson;
import nl.hsleiden.persistence.ContactPersonDAO;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.NotFoundException;
import java.util.List;

@Singleton
public class ContactactService extends BaseService<ContactPerson, ContactPersonDAO> {

    @Inject
    public ContactactService(ContactPersonDAO dao)
    {
        super(dao);
    }

    public List<ContactPerson> findByBedrijf(String bedrijf) {
        return dao.findByBedrijf(bedrijf);
    }
}
