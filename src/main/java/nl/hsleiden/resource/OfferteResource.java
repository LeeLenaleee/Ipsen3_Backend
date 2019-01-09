package nl.hsleiden.resource;

import com.fasterxml.jackson.annotation.JsonView;
import io.dropwizard.hibernate.UnitOfWork;
import nl.hsleiden.View;
import nl.hsleiden.model.OfferteModel;
import nl.hsleiden.service.OfferteService;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Singleton
@Path("/offerte")
@RolesAllowed("user")
@Produces(MediaType.APPLICATION_JSON)
public class OfferteResource {
    private final OfferteService service;

    @Inject
    public OfferteResource(OfferteService service) { this.service = service; }

    @GET
    @Path("/{id}")
    @UnitOfWork
    @JsonView(View.Protected.class)
    public OfferteModel findById(@PathParam("id") int id) {
        return service.findById(id);
    }

    @GET
    @UnitOfWork
    @JsonView(View.Protected.class)
    public List<OfferteModel> findAll() {
        return service.findAll();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @UnitOfWork
    @JsonView(View.Public.class)
    public void create(@Valid OfferteModel OfferteModel)
    {
        service.create(OfferteModel);
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @UnitOfWork
    @JsonView(View.Public.class)
    public void delete(@Valid OfferteModel OfferteModel)
    {
        service.delete(OfferteModel);
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @UnitOfWork
    @JsonView(View.Public.class)
    public void update(@PathParam("id") int id, @Valid OfferteModel user)
    {
        service.update(user, id);
    }
}
