package nl.hsleiden.resource;

import io.dropwizard.hibernate.UnitOfWork;
import nl.hsleiden.model.OfferteModel;
import nl.hsleiden.service.OfferteService;
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
@Path("/offerte")
@Produces(MediaType.APPLICATION_JSON)
public class OfferteResource {
    private final OfferteService offerteService;

    @Inject
    public OfferteResource(OfferteService offerteService){this.offerteService = offerteService;}

    @Path("/download")
    @GET
    @UnitOfWork
    @Produces({"application/pdf"})
    public File getFile(@QueryParam("id") int id) {
        return PDFWriter.maakOfferte(this.offerteService.findById(id));
    }

    @Path("/json")
    @GET
    @UnitOfWork
    @Produces(MediaType.APPLICATION_JSON)
    public OfferteModel getJson(@QueryParam("id") int id) {
        return this.offerteService.findById(id);
    }
}
