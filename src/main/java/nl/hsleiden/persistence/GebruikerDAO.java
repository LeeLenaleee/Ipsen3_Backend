package nl.hsleiden.persistence;

import nl.hsleiden.model.GebruikerModel;
import nl.hsleiden.model.TelefoonnummerModel;
import org.hibernate.SessionFactory;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class GebruikerDAO extends BaseDAO<GebruikerModel> {

    @Inject
    public GebruikerDAO(SessionFactory factory) { super(GebruikerModel.class, factory); }
}
