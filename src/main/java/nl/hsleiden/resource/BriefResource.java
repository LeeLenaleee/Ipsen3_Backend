package nl.hsleiden.resource;

import com.fasterxml.jackson.annotation.JsonView;
import io.dropwizard.hibernate.UnitOfWork;
import nl.hsleiden.View;
import nl.hsleiden.model.BriefModel;
import nl.hsleiden.persistence.BriefDAO;
import nl.hsleiden.service.BriefService;
import nl.hsleiden.utility.PDFWriter;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.io.File;
import java.util.List;

@Singleton
@Path("/brief")
@RolesAllowed("USER")
@Produces(MediaType.APPLICATION_JSON)
public class BriefResource extends BaseResource<BriefModel, BriefDAO, BriefService> {

    @Inject
    public BriefResource(BriefService service) {
        super(service);
    }

    @Path("/download")
    @GET
    @UnitOfWork
    @Produces({"application/pdf"})
    public File getFile(@QueryParam("id") int id) {
        return PDFWriter.maakBrief(super.findById(id));
    }

    @GET
    @Path("/zoek/")
    @UnitOfWork
    @JsonView(View.Protected.class)
    @Produces(MediaType.APPLICATION_JSON)
    public List<BriefModel> findByOmschrijving(@QueryParam("geadreseerde") String geadreseerde) {
        return service.findByGeadreseerde(geadreseerde);
    }
}
