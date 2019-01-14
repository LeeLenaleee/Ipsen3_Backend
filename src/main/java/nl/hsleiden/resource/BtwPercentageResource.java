package nl.hsleiden.resource;

import nl.hsleiden.model.BtwPercentageModel;
import nl.hsleiden.persistence.BtwPercentageDAO;
import nl.hsleiden.service.BtwPercentageService;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.Path;

@Singleton
@Path("/btwpercentage")
@RolesAllowed("USER")
public class BtwPercentageResource extends BaseResource<BtwPercentageModel, BtwPercentageDAO, BtwPercentageService> {

    @Inject
    public BtwPercentageResource(BtwPercentageService service) {
        super(service);
    }
}
