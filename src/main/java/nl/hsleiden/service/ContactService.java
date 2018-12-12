package nl.hsleiden.service;

import nl.hsleiden.model.Bedrijf;
import nl.hsleiden.model.Contact;
import nl.hsleiden.persistence.ContactDAO;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.Collection;

@Singleton
public class ContactService extends BaseService<Contact> {

    private final ContactDAO dao;

    @Inject
    public ContactService(ContactDAO dao) {
        this.dao = dao;
    }

    public Collection<Contact> getAll() {
        return dao.getAll();
    }

    public Contact get(int id) {
        return dao.get(id); // requireResult?
    }

    public Collection<Bedrijf> getBedrijven() {
        return dao.getBedrijven();
    }

    public void add(Contact contact) {
        dao.insert(contact);
    }

    public void update(Contact contact) {
        //TODO Vaststellen of dit de geauthenticeerde gebruiker is
        dao.update(contact);
    }

    public void delete(int id) {
        dao.delete(id);
    }
}
