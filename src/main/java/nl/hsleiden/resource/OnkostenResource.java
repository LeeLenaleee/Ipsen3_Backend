package nl.hsleiden.resource;

import com.fasterxml.jackson.annotation.JsonView;
import com.google.inject.Singleton;
import io.dropwizard.hibernate.UnitOfWork;
import nl.hsleiden.View;
import nl.hsleiden.model.OnkostenModel;
import nl.hsleiden.persistence.OnkostenDAO;
import nl.hsleiden.service.OnkostenService;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * @author Simon van Kouteren
 */

@Singleton
@Path("/onkosten")
@RolesAllowed("USER")
public class OnkostenResource extends BaseResource<OnkostenModel, OnkostenDAO, OnkostenService> {

    @Inject
    public OnkostenResource(OnkostenService service) {
        super(service);
    }

    @GET
    @Path("/zoek/")
    @UnitOfWork
    @JsonView(View.Protected.class)
    @Produces(MediaType.APPLICATION_JSON)
    public List<OnkostenModel> findByOmschrijving(@QueryParam("omschrijving") String omschrijving) {
        return service.findByOmschrijving(omschrijving);
    }
}
