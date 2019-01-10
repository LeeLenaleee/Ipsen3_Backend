package nl.hsleiden.service;

import io.dropwizard.auth.AuthenticationException;
import io.dropwizard.auth.Authenticator;
import io.dropwizard.auth.Authorizer;
import io.dropwizard.auth.UnauthorizedHandler;
import io.dropwizard.auth.basic.BasicCredentials;
import io.dropwizard.hibernate.UnitOfWork;
import nl.hsleiden.model.GebruikerModel;
import nl.hsleiden.model.Role;
import nl.hsleiden.persistence.AuthDAO;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.ForbiddenException;
import javax.ws.rs.core.Response;
import java.util.Optional;

/**
 * @author Jaccao van den Berg, Kasper van den Berg
 */
@Singleton
public class AuthService implements Authenticator<BasicCredentials, GebruikerModel>, Authorizer<GebruikerModel>, UnauthorizedHandler {
    AuthDAO dao;

    @Inject
    public AuthService(AuthDAO dao) {
        this.dao = dao;
    }

    @UnitOfWork
    @Override
    public Optional<GebruikerModel> authenticate(BasicCredentials credentials) throws AuthenticationException {
        return dao.getByCredentials(credentials);
    }

    @Override
    public boolean authorize(GebruikerModel model, String rolname) {
        return model.hasRole(Role.valueOf(rolname));
    }

    @Override
    public Response buildResponse(String prefix, String realm) {
        throw new ForbiddenException();
    }
}