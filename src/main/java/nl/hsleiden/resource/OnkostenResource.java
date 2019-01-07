package nl.hsleiden.resource;

import com.fasterxml.jackson.annotation.JsonView;
import com.google.inject.Singleton;
import io.dropwizard.hibernate.UnitOfWork;
import nl.hsleiden.View;
import nl.hsleiden.model.OnkostenModel;
import nl.hsleiden.service.OnkostenService;

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
@Produces(MediaType.APPLICATION_JSON)
public class OnkostenResource {
    private final OnkostenService service;

    @Inject
    public OnkostenResource(OnkostenService service)
    {
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
    @UnitOfWork
    @JsonView(View.Protected.class)
    public List<OnkostenModel> findByOmschrijving(@QueryParam("omschrijving") String omschrijving) {
        return service.findByOmschrijving(omschrijving);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @UnitOfWork
    @JsonView(View.Public.class)
    public void create(@Valid OnkostenModel onkostenModel)
    {
        System.out.println("hij komt hier niet"); service.create(onkostenModel);
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @UnitOfWork
    @JsonView(View.Public.class)
    public void delete(@Valid OnkostenModel onkostenModel)
    {
        service.delete(onkostenModel);
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @UnitOfWork
    @JsonView(View.Public.class)
    public void update(@PathParam("id") int id, @Valid OnkostenModel onkostenModel)
    {
        service.update(id, onkostenModel);
    }
}
