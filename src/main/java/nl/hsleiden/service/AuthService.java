package nl.hsleiden.service;

import io.dropwizard.auth.AuthenticationException;
import io.dropwizard.auth.Authenticator;
import io.dropwizard.auth.Authorizer;
import io.dropwizard.auth.UnauthorizedHandler;
import io.dropwizard.auth.basic.BasicCredentials;
import io.dropwizard.hibernate.UnitOfWork;
import nl.hsleiden.model.GebruikerModel;
import nl.hsleiden.model.Role;

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
    private GebruikerService service;

    @Inject
    public AuthService(GebruikerService service) {
        this.service = service;
    }

    @UnitOfWork
    @Override
    public Optional<GebruikerModel> authenticate(BasicCredentials credentials) throws AuthenticationException {
        return service.getByCredentials(credentials.getUsername(), credentials.getPassword());
    }

    @Override
    public boolean authorize(GebruikerModel model, String rolname) {
        System.err.println("pjeter"+model.hasRole(Role.valueOf(rolname)));
        return model.hasRole(Role.valueOf(rolname));
    }

    @Override
    public Response buildResponse(String prefix, String realm) {
        throw new ForbiddenException();
    }
}