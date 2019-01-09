package nl.hsleiden.service;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.ForbiddenException;
import javax.ws.rs.core.Response;

import io.dropwizard.auth.AuthenticationException;
import io.dropwizard.auth.Authenticator;
import io.dropwizard.auth.Authorizer;
import io.dropwizard.auth.UnauthorizedHandler;
import io.dropwizard.auth.basic.BasicCredentials;
import io.dropwizard.hibernate.UnitOfWork;
import nl.hsleiden.model.GebruikerModel;
import nl.hsleiden.model.LoginGebruikerModel;
import nl.hsleiden.persistence.LoginGebruikerDAO;

import java.util.Optional;

/**
 *
 * @author Jaccao van den Berg, Kasper van den Berg
 */
@Singleton
public class LoginGebruikerService implements Authenticator<BasicCredentials, GebruikerModel>, Authorizer<GebruikerModel>, UnauthorizedHandler {
    LoginGebruikerDAO dao;

    //public LoginGebruikerService() {}

    @Inject
    public LoginGebruikerService(LoginGebruikerDAO dao)
    {
        this.dao = dao;
    }

    public Optional<GebruikerModel> getByEmailAddress(LoginGebruikerModel loginGebruikerModel) {
        return dao.getByEmailAddress(loginGebruikerModel);
    }

    @UnitOfWork
    @Override
    public Optional<GebruikerModel> authenticate(BasicCredentials credentials) throws AuthenticationException {
        System.out.println("CREDS:\t" + credentials.getUsername() + credentials.getPassword());
        LoginGebruikerModel loginGebruikerModel = new LoginGebruikerModel(credentials.getUsername(), credentials.getPassword());

        return getByEmailAddress(loginGebruikerModel);
    }

    @Override
    public boolean authorize(GebruikerModel model, String rolname) {
        System.out.println("CREDS:\t" + model.getFullName() + model.getPassword());

        return model.hasRole(rolname);
    }

    @Override
    public Response buildResponse(String prefix, String realm) {
        throw new ForbiddenException();
    }
}