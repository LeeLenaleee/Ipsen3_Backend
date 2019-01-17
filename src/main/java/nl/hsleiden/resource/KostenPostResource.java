package nl.hsleiden.resource;

import com.fasterxml.jackson.annotation.JsonView;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import io.dropwizard.hibernate.UnitOfWork;
import nl.hsleiden.View;
import nl.hsleiden.model.KostenpostModel;
import nl.hsleiden.persistence.KostenPostDAO;
import nl.hsleiden.service.KostenPostService;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Singleton
@Path("/kostenpost")
@RolesAllowed("USER")
public class KostenPostResource extends BaseResource<KostenpostModel, KostenPostDAO, KostenPostService> {
    @Inject
    public KostenPostResource(KostenPostService service) {
        super(service);
    }

    @GET
    @Path("/name")
    @UnitOfWork
    @JsonView(View.Protected.class)
    @Produces(MediaType.APPLICATION_JSON)
    public List<KostenpostModel> findByName(@QueryParam("name") String name) {
        List<KostenpostModel> results = service.findByName(name);

        // Didn't find any matches.
        if (results.isEmpty()) {
            throw new NotFoundException();
        }

        return results;
    }
}
