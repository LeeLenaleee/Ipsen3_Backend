package nl.hsleiden.resource;

import nl.hsleiden.PDFWriter;

import javax.inject.Singleton;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

@Provider
@Singleton
@Path("/download")
public class FactuurDownloadResource {
    private String testPdf = "C:\\Users\\Jacco School\\IdeaProjects\\Ipsen3_Backend\\src\\main\\java\\nl\\hsleiden\\pdfFiles\\facturen\\112.pdf";


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

    @Path("/pdfDoc/")
    @GET
    @Produces({"application/pdf"})
    public File getFile3() {
        return PDFWriter.maakFactuur("01-01-2019","ziekenwagen jeweetzelf","5","4","3","2","55");
    }
}
