package nl.hsleiden.service;

import nl.hsleiden.model.ContactPerson;
import nl.hsleiden.persistence.ContactPersonDAO;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class ContactactService extends BaseService<ContactPerson> {
    private final ContactPersonDAO dao;

    @Inject
    public ContactactService(ContactPersonDAO dao)
    {
        this.dao = dao;
    }

    public ContactPerson get(int id)
    {
        return requireResult(dao.get(id));
    }

    public void add(ContactPerson contactPerson) {
        dao.add(contactPerson);
    }

    public void delete(int id) {
        dao.delete(id);
    }

}
