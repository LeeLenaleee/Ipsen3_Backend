package nl.hsleiden.resource;

import io.dropwizard.hibernate.UnitOfWork;
import nl.hsleiden.service.FactuurService;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
import java.io.File;
import java.io.FileNotFoundException;
@Provider
@Singleton
@Path("/factuur")
public class FactuurResource {
    private final FactuurService factuurService;
    private String testPdf = "C:\\Users\\Jacco School\\IdeaProjects\\Ipsen3_Backend\\src\\main\\java\\nl\\hsleiden\\pdfFiles\\facturen\\112.pdf";

    @Inject
    public FactuurResource(FactuurService service){this.factuurService = service;}

    //download de pdf file automatish
    @Path("/pdf1/{id}")
    @GET
    @Produces({"application/pdf"})
    public Response getFile1(@PathParam("id") int id)
    {
        File file = new File(testPdf);
        Response.ResponseBuilder response = Response.ok((Object) file);
        response.header("Content-Disposition","attachment; filename=test.pdf");
        return response.build();
    }
    //opened de pdf file in de browser dus je moet zelf nog op download klikken
    @Path("pdf2/{id}")
    @GET
    @Produces({"application/pdf"})
    public File getFile2(@PathParam("id") int id) throws FileNotFoundException {
        if (id == 1){
            File file = new File(testPdf);
            return file;
        }else throw new FileNotFoundException("file not found");
    }

    @Path("/download")
    @GET
    @UnitOfWork
    @Produces({"application/pdf"})
    public File getFile(@QueryParam("id") int id) {
        return this.factuurService.getById(id);
    }
}
