package nl.hsleiden.resource;

import com.fasterxml.jackson.annotation.JsonView;
import io.dropwizard.hibernate.UnitOfWork;
import nl.hsleiden.View;
import nl.hsleiden.model.GebruikerModel;
import nl.hsleiden.service.GebruikerService;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Singleton
@Path("/gebruiker")
@Produces(MediaType.APPLICATION_JSON)
public class GebruikerResource {
    private final GebruikerService service;

    @Inject
    public GebruikerResource(GebruikerService service) { this.service = service; }

    @GET
    @Path("/{id}")
    @UnitOfWork
    @JsonView(View.Protected.class)
    public GebruikerModel findById(@PathParam("id") int id) {
        return service.findById(id);
    }

    @GET
    @UnitOfWork
    @JsonView(View.Protected.class)
    public List<GebruikerModel> findAll() {
        return service.findAll();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @UnitOfWork
    @JsonView(View.Public.class)
    public void create(@Valid GebruikerModel GebruikerModel)
    {
        service.create(GebruikerModel);
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @UnitOfWork
    @JsonView(View.Public.class)
    public void delete(@Valid GebruikerModel GebruikerModel)
    {
        service.delete(GebruikerModel);
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @UnitOfWork
    @JsonView(View.Public.class)
    public void update(@PathParam("id") int id, @Valid GebruikerModel user)
    {
        service.update(user, id);
    }
}
