package nl.hsleiden.resource;

import nl.hsleiden.model.TelefoonnummerModel;
import nl.hsleiden.persistence.TelefoonnummerDAO;
import nl.hsleiden.service.TelefoonnummerService;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.Path;

@Singleton
@Path("/telefoonnummer")
@RolesAllowed("user")
public class TelefoonnummerResource extends BaseResource<TelefoonnummerModel, TelefoonnummerDAO, TelefoonnummerService> {

    @Inject
    public TelefoonnummerResource(TelefoonnummerService service) {
        super(service);
    }
}
