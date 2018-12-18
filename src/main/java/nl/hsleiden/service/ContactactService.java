package nl.hsleiden.service;

import nl.hsleiden.model.ContactPerson;
import nl.hsleiden.persistence.ContactPersonDAO;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class ContactactService extends BaseService<ContactPerson, ContactPersonDAO> {

    @Inject
    public ContactactService(ContactPersonDAO dao)
    {
        super(dao);
    }
}
