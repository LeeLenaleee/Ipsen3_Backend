package nl.hsleiden.resource;

import com.fasterxml.jackson.annotation.JsonView;
import com.google.inject.Singleton;
import io.dropwizard.hibernate.UnitOfWork;
import nl.hsleiden.View;
import nl.hsleiden.model.OnkostenModel;
import nl.hsleiden.service.OnkostenService;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * @author Simon van Kouteren
 */

@Singleton
@Path("/onkosten")
@RolesAllowed("user")
@Produces(MediaType.APPLICATION_JSON)
public class OnkostenResource {
    private final OnkostenService service;

    @Inject
    public OnkostenResource(OnkostenService service) {
        this.service = service;
    }

    @GET
    @Path("/{id}")
    @UnitOfWork
    @JsonView(View.Protected.class)
    public OnkostenModel findById(@PathParam("id") int id) {
        return service.findById(id);
    }

    @GET
    @Path("/expenses/{omschrijving}")
    @UnitOfWork
    @JsonView(View.Protected.class)
    public List<OnkostenModel> findByOmschrijving(@PathParam("omschrijving") String omschrijving) {
        return service.findByOmschrijving(omschrijving);
    }

    @GET
    @UnitOfWork
    @JsonView(View.Protected.class)
    public List<OnkostenModel> findAll() {
        return service.findAll();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @UnitOfWork
    @JsonView(View.Public.class)
    public void create(@Valid OnkostenModel onkostenModel) {
        service.create(onkostenModel);
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @UnitOfWork
    @JsonView(View.Public.class)
    public void delete(@Valid OnkostenModel onkostenModel) {
        service.delete(onkostenModel);
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @UnitOfWork
    @JsonView(View.Public.class)
    public void update(@PathParam("id") int id, @Valid OnkostenModel user) {
        service.update(user, id);
    }
}
