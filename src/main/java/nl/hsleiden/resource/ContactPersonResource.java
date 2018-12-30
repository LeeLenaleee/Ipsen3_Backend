package nl.hsleiden.resource;

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
import java.util.List;

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

    @GET
    @UnitOfWork
    @JsonView(View.Protected.class)
    public List<ContactPerson> findByBedrijf(@QueryParam("bedrijf") String bedrijf) {
        return service.findByBedrijf(bedrijf);
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

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @UnitOfWork
    @JsonView(View.Public.class)
    public void update(@PathParam("id") int id, @Valid ContactPerson contactPerson)
    {
        service.update(id, contactPerson);
    }
}
