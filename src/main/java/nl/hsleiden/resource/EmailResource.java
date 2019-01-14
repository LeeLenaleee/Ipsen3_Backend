package nl.hsleiden.resource;

import nl.hsleiden.model.EmailModel;
import nl.hsleiden.persistence.EmailDAO;
import nl.hsleiden.service.EmailService;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.Path;

@Singleton
@Path("/email")
@RolesAllowed("USER")
public class EmailResource extends BaseResource<EmailModel, EmailDAO, EmailService> {

    @Inject
    public EmailResource(EmailService service) {
        super(service);
    }
}
