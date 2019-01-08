package nl.hsleiden.resource;

import com.fasterxml.jackson.annotation.JsonView;
import io.dropwizard.hibernate.UnitOfWork;
import nl.hsleiden.View;
import nl.hsleiden.model.GebruikerModel;
import nl.hsleiden.model.LoginGebruikerModel;
import nl.hsleiden.persistence.LoginGebruikerDAO;
import nl.hsleiden.service.LoginGebruikerService;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.Provider;
import java.util.Optional;

/**
 * @author Jacco van den Berg
 */
@Provider
@Singleton
@Path("/login")
@Produces(MediaType.APPLICATION_JSON)
public class LoginGebruikerResource {
    private final LoginGebruikerService service;

    @Inject
    public LoginGebruikerResource(LoginGebruikerService service) {
        this.service = service;
    }

    @POST
    @UnitOfWork
    @Consumes(MediaType.APPLICATION_JSON)
    @JsonView(View.Protected.class)
    public GebruikerModel get(LoginGebruikerModel loginGebruikerModel)
    {
        Optional<GebruikerModel> gebruiker = this.service.getByEmailAddress(loginGebruikerModel);

        return gebruiker.orElseThrow(() -> new NotAuthorizedException("Failed to login."));
    }
}
