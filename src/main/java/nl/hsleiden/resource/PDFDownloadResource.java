package nl.hsleiden.resource;

import com.fasterxml.jackson.annotation.JsonView;
import io.dropwizard.hibernate.UnitOfWork;
import nl.hsleiden.View;

import javax.inject.Singleton;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
import java.io.File;

@Provider
@Singleton
@Path("/download")
public class PDFDownloadResource {

    //download de pdf file automatish
    @Path("/pdf")
    @GET
    @Produces({"application/pdf"})
    public Response getFile()
    {
        File file = new File("C:\\Users\\Jacco School\\IdeaProjects\\Ipsen3_Backend\\src\\main\\java\\nl\\hsleiden\\resource\\i_islp_mh_5.0.pdf");
        Response.ResponseBuilder response = Response.ok((Object) file);
        response.header("Content-Disposition","attachment; filename=test.pdf");
        return response.build();
    }
    //opened de pdf file in de browser dus je moet zelf nog op download klikken
    @Path("/pdf2")
    @GET
    @Produces({"application/pdf"})
    public File getFile2()
    {
        File file = new File("C:\\Users\\Jacco School\\IdeaProjects\\Ipsen3_Backend\\src\\main\\java\\nl\\hsleiden\\resource\\i_islp_mh_5.0.pdf");
        return file;
    }
}
