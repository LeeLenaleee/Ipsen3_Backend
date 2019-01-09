package nl.hsleiden.service;

import nl.hsleiden.model.ContactPersoonModel;
import nl.hsleiden.model.EmailModel;
import nl.hsleiden.persistence.EmailDAO;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;

@Singleton
public class EmailService extends BaseService<EmailModel, EmailDAO> {

    @Inject
    public EmailService(EmailDAO dao)
    {
        super(dao);
    }

    public void update(EmailModel user, int userId) {
        user.setId(userId);
        super.update(user);
    }
}
