package nl.hsleiden.persistence;

import nl.hsleiden.model.EmailModel;
import nl.hsleiden.model.TelefoonnummerModel;
import org.hibernate.SessionFactory;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class EmailDAO extends BaseDAO<EmailModel> {

    @Inject
    public EmailDAO(SessionFactory factory) { super(EmailModel.class, factory); }
}
