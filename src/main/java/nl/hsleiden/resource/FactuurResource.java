package nl.hsleiden.resource;

import com.fasterxml.jackson.annotation.JsonView;
import io.dropwizard.hibernate.UnitOfWork;
import nl.hsleiden.View;
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
import javax.ws.rs.core.Response;
import java.io.File;

@Singleton
@Path("/factuur")
//@RolesAllowed("USER")
public class FactuurResource extends BaseResource<FactuurModel, FactuurDAO, FactuurService> {

    @Inject
    public FactuurResource(FactuurService service) {
        super(service);
    }

    /*@Path("/download")
    @GET
    @UnitOfWork
    @Produces({"application/pdf"})
    public File getFile(@QueryParam("id") int id) {
        return PDFWriter.maakFactuur(super.findById(id));
    }*/

    @Path("/download")
    @GET
    @UnitOfWork
    @Produces({"application/pdf"})
    public Response getFile(@QueryParam("id") int id) {
        File file = PDFWriter.maakFactuur(super.findById(id));
        Response.ResponseBuilder response = Response.ok(file);
        response.header("Content-Disposition","attachment; filename=test.pdf");
        System.err.println("kap");
        return response.build();
    }

}
