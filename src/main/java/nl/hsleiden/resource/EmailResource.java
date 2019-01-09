package nl.hsleiden.resource;

import com.fasterxml.jackson.annotation.JsonView;
import io.dropwizard.hibernate.UnitOfWork;
import nl.hsleiden.View;
import nl.hsleiden.model.EmailModel;
import nl.hsleiden.service.BtwPercentageService;
import nl.hsleiden.service.EmailService;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Singleton
@Path("/email")
@Produces(MediaType.APPLICATION_JSON)
@RolesAllowed("user")
public class EmailResource {
    private final EmailService service;

    @Inject
    public EmailResource(EmailService service) { this.service = service; }

    @GET
    @Path("/{id}")
    @UnitOfWork
    @JsonView(View.Protected.class)
    public EmailModel findById(@PathParam("id") int id) {
        return service.findById(id);
    }

    @GET
    @UnitOfWork
    @JsonView(View.Protected.class)
    public List<EmailModel> findAll() {
        return service.findAll();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @UnitOfWork
    @JsonView(View.Public.class)
    public void create(@Valid EmailModel EmailModel)
    {
        service.create(EmailModel);
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @UnitOfWork
    @JsonView(View.Public.class)
    public void delete(@Valid EmailModel EmailModel)
    {
        service.delete(EmailModel);
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @UnitOfWork
    @JsonView(View.Public.class)
    public void update(@PathParam("id") int id, @Valid EmailModel user)
    {
        service.update(user, id);
    }
}
