package nl.hsleiden.resource;

import com.fasterxml.jackson.annotation.JsonView;
import io.dropwizard.hibernate.UnitOfWork;
import nl.hsleiden.View;
import nl.hsleiden.model.OfferteModel;
import nl.hsleiden.service.OfferteService;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.File;
import java.util.List;

@Singleton
@Path("/offerte")
@Produces(MediaType.APPLICATION_JSON)
public class OfferteResource {
    private final OfferteService offerteService;

    @Inject
    public OfferteResource(OfferteService offerteService){this.offerteService = offerteService;}

    @Path("/pdf")
    @GET
    @UnitOfWork
    @Produces({"application/pdf"})
    public File getFile(@QueryParam("id") int id) {
        return this.offerteService.getById(id);
    }
}
