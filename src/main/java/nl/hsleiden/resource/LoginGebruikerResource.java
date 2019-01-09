package nl.hsleiden.resource;

import com.fasterxml.jackson.annotation.JsonView;
import io.dropwizard.hibernate.UnitOfWork;
import nl.hsleiden.View;
import nl.hsleiden.model.GebruikerModel;
import nl.hsleiden.service.AuthService;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.Provider;

/**
 * @author Jacco van den Berg
 */
@Provider
@Singleton
@Path("/login")
@Produces(MediaType.APPLICATION_JSON)
public class LoginGebruikerResource {
    private final AuthService service;

    @Inject
    public LoginGebruikerResource(AuthService service) {
        this.service = service;
    }

    @POST
    @UnitOfWork
    @Consumes(MediaType.APPLICATION_JSON)
    @JsonView(View.Protected.class)
    public void get(GebruikerModel gebruikerModel)
    {

    }
}
