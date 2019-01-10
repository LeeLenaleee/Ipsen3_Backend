package nl.hsleiden.resource;

import io.dropwizard.hibernate.UnitOfWork;
import nl.hsleiden.model.BriefModel;
import nl.hsleiden.persistence.BriefDAO;
import nl.hsleiden.service.BriefService;
import nl.hsleiden.utility.PDFWriter;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.io.File;

@Singleton
@Path("/brief")
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
}
