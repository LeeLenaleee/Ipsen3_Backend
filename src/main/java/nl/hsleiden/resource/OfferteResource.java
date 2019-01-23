package nl.hsleiden.resource;

import com.fasterxml.jackson.annotation.JsonView;
import io.dropwizard.hibernate.UnitOfWork;
import nl.hsleiden.View;
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
import javax.ws.rs.core.MediaType;
import java.io.File;
import java.util.List;

@Singleton
@Path("/offerte")
@RolesAllowed("USER")
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

    @GET
    @Path("/zoek/")
    @UnitOfWork
    @JsonView(View.Protected.class)
    @Produces(MediaType.APPLICATION_JSON)
    public List<OfferteModel> findByOmschrijving(@QueryParam("correspondentie") int correspondentie) {
        return service.findByCorrespondentieNummer(correspondentie);
    }
}
