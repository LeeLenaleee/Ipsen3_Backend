package nl.hsleiden.resource;

import io.dropwizard.hibernate.UnitOfWork;
import nl.hsleiden.model.OfferteModel;
import nl.hsleiden.persistence.OfferteDAO;
import nl.hsleiden.service.OfferteService;
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
@Path("/offerte")
@RolesAllowed("user")
public class OfferteResource extends BaseResource<OfferteModel, OfferteDAO, OfferteService> {

    @Inject
    public OfferteResource(OfferteService service) {
        super(service);
    }

    @Path("/download")
    @GET
    @UnitOfWork
    @Produces({"application/pdf"})
    public File getFile(@QueryParam("id") int id) {
        return PDFWriter.maakOfferte(super.findById(id));
    }
}
