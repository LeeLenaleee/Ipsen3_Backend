package nl.hsleiden.resource;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;

import com.fasterxml.jackson.annotation.JsonView;
import com.google.inject.Singleton;
import io.dropwizard.hibernate.UnitOfWork;
import nl.hsleiden.View;
import nl.hsleiden.model.ContactPerson;
import nl.hsleiden.service.ContactactService;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Singleton
@Path("/contacts")
@Produces(MediaType.APPLICATION_JSON)
public class ContactPersonResource {
    private final ContactactService service;

    @Inject
    public ContactPersonResource(ContactactService service)
    {
        this.service = service;
    }

    @GET
    @Path("/{id}")
    @UnitOfWork
    @JsonView(View.Protected.class)
    public ContactPerson findById(@PathParam("id") int id) {
        return service.findById(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @UnitOfWork
    @JsonView(View.Public.class)
    public void create(@Valid ContactPerson contactPerson)
    {
        service.create(contactPerson);
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @UnitOfWork
    @JsonView(View.Public.class)
    public void delete(@Valid ContactPerson contactPerson)
    {
        service.delete(contactPerson);
    }
}
