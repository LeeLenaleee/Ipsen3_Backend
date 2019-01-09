package nl.hsleiden.resource;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;

import com.fasterxml.jackson.annotation.JsonView;
import com.google.inject.Singleton;
import io.dropwizard.hibernate.UnitOfWork;
import nl.hsleiden.View;
import nl.hsleiden.model.ContactPersoonModel;
import nl.hsleiden.model.OnkostenModel;
import nl.hsleiden.service.ContactPersoonService;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Singleton
@Path("/contacten")
@Produces(MediaType.APPLICATION_JSON)
public class ContactPersoonResource {
    private final ContactPersoonService service;

    @Inject
    public ContactPersoonResource(ContactPersoonService service)
    {
        this.service = service;
    }

    @GET
    @Path("/{id}")
    @UnitOfWork
    @JsonView(View.Protected.class)
    @RolesAllowed("admin")
    public ContactPersoonModel findById(@PathParam("id") int id) {
        return service.findById(id);
    }

    @GET
    @Path("/bedrijf")
    @UnitOfWork
    @JsonView(View.Protected.class)
    public List<ContactPersoonModel> findByBedrijf(@QueryParam("bedrijf") String bedrijf) {
        List <ContactPersoonModel> results = service.findByBedrijf(bedrijf);

        // Didn't find any matches.
        if (results.isEmpty()) {
            throw new NotFoundException();
        }

        return results;
    }

    @GET
    @UnitOfWork
    @JsonView(View.Protected.class)
    @Path("/naam")
    public List<ContactPersoonModel> findByNaam(@QueryParam("voornaam") String voornaam, @QueryParam("achternaam") String achternaam) {
        List <ContactPersoonModel> results = service.findByNaam(voornaam, achternaam);

        // Didn't find any matches.
        if (results.isEmpty()) {
            throw new NotFoundException();
        }

        return results;
    }

    @GET
    @UnitOfWork
    @JsonView(View.Protected.class)
    public List<ContactPersoonModel> findAll() {
        return service.findAll();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @UnitOfWork
    @JsonView(View.Public.class)
    public void create(@Valid ContactPersoonModel contactPersoonModel)
    {
        service.create(contactPersoonModel);
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @UnitOfWork
    @JsonView(View.Public.class)
    public void delete(@Valid ContactPersoonModel contactPersoonModel)
    {
        service.delete(contactPersoonModel);
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @UnitOfWork
    @JsonView(View.Public.class)
    public void update(@PathParam("id") int id, @Valid ContactPersoonModel user)
    {
        service.update(user, id);
    }

}
