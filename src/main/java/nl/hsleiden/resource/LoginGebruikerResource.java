package nl.hsleiden.resource;

import com.fasterxml.jackson.annotation.JsonView;
import io.dropwizard.hibernate.UnitOfWork;
import nl.hsleiden.View;
import nl.hsleiden.model.CredentialsModel;
import nl.hsleiden.model.GebruikerModel;
import nl.hsleiden.service.GebruikerService;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.Provider;

/**
 * @author Jacco van den Berg
 */
@Provider
@Singleton
@Path("/login")
public class LoginGebruikerResource {
    private final GebruikerService service;

    @Inject
    public LoginGebruikerResource(GebruikerService service) {
        this.service = service;
    }

    @POST
    @UnitOfWork
    @Consumes(MediaType.APPLICATION_JSON)
    @JsonView(View.Public.class)
    @Produces(MediaType.APPLICATION_JSON)
    public GebruikerModel get(@Valid CredentialsModel credentials) {
        return service.getByCredentials(credentials.getGebruikersnaam(), credentials.getWachtwoord())
                .orElseThrow(() -> new NotAuthorizedException("Required credentials"));
    }
}
