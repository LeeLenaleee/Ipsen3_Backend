package nl.hsleiden.resource;

import javax.inject.Inject;

import com.fasterxml.jackson.annotation.JsonView;
import com.google.inject.Singleton;
import io.dropwizard.hibernate.UnitOfWork;
import nl.hsleiden.View;
import nl.hsleiden.model.ContactPersonModel;
import nl.hsleiden.service.ContactPersonService;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Singleton
@Path("/contacts")
@Produces(MediaType.APPLICATION_JSON)
public class ContactPersonResource {
    private final ContactPersonService service;

    @Inject
    public ContactPersonResource(ContactPersonService service)
    {
        this.service = service;
    }

    @GET
    @Path("/{id}")
    @UnitOfWork
    @JsonView(View.Protected.class)
    public ContactPersonModel findById(@PathParam("id") int id) {
        return service.findById(id);
    }

    @GET
    @UnitOfWork
    @JsonView(View.Protected.class)
    public List<ContactPersonModel> findByBedrijf(@QueryParam("bedrijf") String bedrijf) {
        List <ContactPersonModel> results = service.findByBedrijf(bedrijf);

        // Didn't find any matches.
        if (results.isEmpty()) {
            throw new NotFoundException();
        }

        return results;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @UnitOfWork
    @JsonView(View.Public.class)
    public void create(@Valid ContactPersonModel contactPersonModel)
    {
        service.create(contactPersonModel);
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @UnitOfWork
    @JsonView(View.Public.class)
    public void delete(@Valid ContactPersonModel contactPersonModel)
    {
        service.delete(contactPersonModel);
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @UnitOfWork
    @JsonView(View.Public.class)
    public void update(@PathParam("id") int id, @Valid ContactPersonModel contactPersonModel)
    {
        service.update(id, contactPersonModel);
    }
}
