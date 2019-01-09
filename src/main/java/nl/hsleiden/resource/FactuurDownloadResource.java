package nl.hsleiden.resource;

import io.dropwizard.hibernate.UnitOfWork;
import nl.hsleiden.model.FactuurModel;
import nl.hsleiden.service.FactuurService;
import nl.hsleiden.utility.PDFWriter;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Optional;

@Provider
@Singleton
@Path("/download")
public class FactuurDownloadResource {
    private final FactuurService factuurService;
    private String testPdf = "C:\\Users\\Jacco School\\IdeaProjects\\Ipsen3_Backend\\src\\main\\java\\nl\\hsleiden\\pdfFiles\\facturen\\112.pdf";

    @Inject
    public FactuurDownloadResource(FactuurService service){this.factuurService = service;}

    //download de pdf file automatish
    @Path("/pdf/{id}")
    @GET
    @Produces({"application/pdf"})
    public Response getFile(@PathParam("id") int id)
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

    @Path("/pdfDoc2")
    @GET
    @UnitOfWork
    @Produces({"application/pdf"})
    public File getFile4(@QueryParam("id") int id) {
        System.err.println(id);
        return this.factuurService.getById(id);
    }
}
