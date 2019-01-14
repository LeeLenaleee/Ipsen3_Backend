package nl.hsleiden.persistence;

import nl.hsleiden.model.TelefoonnummerModel;
import org.hibernate.SessionFactory;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class TelefoonnummerDAO extends CrudDAOImpl<TelefoonnummerModel> {

    @Inject
    public TelefoonnummerDAO(SessionFactory factory) {
        super(TelefoonnummerModel.class, factory);
    }
}
