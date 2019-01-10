package nl.hsleiden.resource;

import nl.hsleiden.model.OfferteModel;
import nl.hsleiden.persistence.OfferteDAO;
import nl.hsleiden.service.OfferteService;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.Path;

@Singleton
@Path("/offerte")
@RolesAllowed("user")
public class OfferteResource extends BaseResource<OfferteModel, OfferteDAO, OfferteService> {

    @Inject
    public OfferteResource(OfferteService service) {
        super(service);
    }
}
