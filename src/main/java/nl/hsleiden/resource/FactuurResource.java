package nl.hsleiden.resource;

import io.dropwizard.hibernate.UnitOfWork;
import nl.hsleiden.model.FactuurModel;
import nl.hsleiden.service.FactuurService;
import nl.hsleiden.utility.PDFWriter;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
import java.io.File;
import java.io.FileNotFoundException;
@Provider
@Singleton
@Path("/factuur")
public class FactuurResource{
    private final FactuurService factuurService;

    @Inject
    public FactuurResource(FactuurService service){this.factuurService = service;}

    @Path("/download")
    @GET
    @UnitOfWork
    @Produces({"application/pdf"})
    public File getFile(@QueryParam("id") int id) {
        return PDFWriter.maakFactuur(this.factuurService.findById(id));
    }

    @Path("/json")
    @GET
    @UnitOfWork
    @Produces(MediaType.APPLICATION_JSON)
    public FactuurModel getJson(@QueryParam("id") int id) {
        return this.factuurService.findById(id);
    }

    @Path("/insert")
    @POST
    @UnitOfWork
    @Consumes(MediaType.APPLICATION_JSON)
    public void voegToe(){

    }
}
