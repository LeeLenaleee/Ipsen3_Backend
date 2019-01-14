package nl.hsleiden.service;

import nl.hsleiden.model.EmailModel;
import nl.hsleiden.persistence.EmailDAO;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class EmailService extends CrudServiceImpl<EmailModel> {

    @Inject
    public EmailService(EmailDAO dao) {
        super(dao);
    }
}
