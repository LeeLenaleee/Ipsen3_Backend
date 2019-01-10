package nl.hsleiden.resource;

import io.dropwizard.hibernate.UnitOfWork;
import nl.hsleiden.model.FactuurModel;
import nl.hsleiden.persistence.FactuurDAO;
import nl.hsleiden.service.FactuurService;
import nl.hsleiden.utility.PDFWriter;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import java.io.File;

@Singleton
@Path("/factuur")
@RolesAllowed("user")
public class FactuurResource extends BaseResource<FactuurModel, FactuurDAO, FactuurService> {

    @Inject
    public FactuurResource(FactuurService service) {
        super(service);
    }

    @Path("/download")
    @GET
    @UnitOfWork
    @Produces({"application/pdf"})
    public File getFile(@QueryParam("id") int id) {
        return PDFWriter.maakFactuur(super.findById(id));
    }

}
