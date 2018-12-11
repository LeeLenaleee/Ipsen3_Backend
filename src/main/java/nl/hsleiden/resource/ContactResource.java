package nl.hsleiden.resource;

import com.fasterxml.jackson.annotation.JsonView;
import com.google.inject.Singleton;
import nl.hsleiden.View;
import nl.hsleiden.model.Contact;
import nl.hsleiden.service.ContactService;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.Collection;
import java.util.Optional;

@Singleton
@Path("/contact")
@Produces(MediaType.APPLICATION_JSON)
public class ContactResource
{
    private final ContactService service;

    @Inject
    public ContactResource(ContactService service)
    {
        this.service = service;
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
//    @GET
//    @JsonView(View.Public.class)
//    @RolesAllowed("GUEST")
//    public Collection<Contact> retrieveAll()
//    {
//        return service.getAll();
//    }
    public String werktDit() {
        return "dit zou moeten werken?";
    }
}
