package nl.hsleiden.persistence;

import nl.hsleiden.model.GebruikerModel;
import org.hibernate.SessionFactory;

import javax.inject.Inject;

public class GebruikerDAO extends BaseDAO<GebruikerModel> {

    @Inject
    public GebruikerDAO(SessionFactory factory) { super(GebruikerModel.class, factory); }
}
