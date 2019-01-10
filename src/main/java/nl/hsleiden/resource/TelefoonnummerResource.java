package nl.hsleiden.resource;

import com.fasterxml.jackson.annotation.JsonView;
import io.dropwizard.hibernate.UnitOfWork;
import nl.hsleiden.View;
import nl.hsleiden.model.TelefoonnummerModel;
import nl.hsleiden.service.TelefoonnummerService;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Singleton
@Path("/telefoonnummer")
@Produces(MediaType.APPLICATION_JSON)
@RolesAllowed("user")
public class TelefoonnummerResource {
    private final TelefoonnummerService service;

    @Inject
    public TelefoonnummerResource(TelefoonnummerService service) {
        this.service = service;
    }

    @GET
    @Path("/{id}")
    @UnitOfWork
    @JsonView(View.Protected.class)
    public TelefoonnummerModel findById(@PathParam("id") int id) {
        return service.findById(id);
    }

    @GET
    @UnitOfWork
    @JsonView(View.Protected.class)
    public List<TelefoonnummerModel> findAll() {
        return service.findAll();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @UnitOfWork
    @JsonView(View.Public.class)
    public void create(@Valid TelefoonnummerModel TelefoonnummerModel) {
        service.create(TelefoonnummerModel);
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @UnitOfWork
    @JsonView(View.Public.class)
    public void delete(@Valid TelefoonnummerModel TelefoonnummerModel) {
        service.delete(TelefoonnummerModel);
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @UnitOfWork
    @JsonView(View.Public.class)
    public void update(@PathParam("id") int id, @Valid TelefoonnummerModel user) {
        service.update(user, id);
    }
}
