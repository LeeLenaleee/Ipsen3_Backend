package nl.hsleiden.service;

import javax.inject.Inject;
import javax.inject.Singleton;
import nl.hsleiden.model.GebruikerModel;
import nl.hsleiden.model.LoginGebruikerModel;
import nl.hsleiden.persistence.LoginGebruikerDAO;
import nl.hsleiden.persistence.LoginGebruikerDAO;

import java.util.Optional;

/**
 *
 * @author Jaccao van den Berg, Kasper van den Berg
 */
@Singleton
public class LoginGebruikerService {
    LoginGebruikerDAO dao;

    @Inject
    public LoginGebruikerService(LoginGebruikerDAO dao)
    {
        this.dao = dao;
    }

    public Optional<GebruikerModel> getByEmailAddress(LoginGebruikerModel loginGebruikerModel) {
        return dao.getByEmailAddress(loginGebruikerModel);
    }
}