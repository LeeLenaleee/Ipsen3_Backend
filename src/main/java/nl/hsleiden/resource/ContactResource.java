package nl.hsleiden.resource;

import com.fasterxml.jackson.annotation.JsonView;
import com.google.inject.Singleton;
import nl.hsleiden.View;
import nl.hsleiden.model.Bedrijf;
import nl.hsleiden.model.Contact;
import nl.hsleiden.service.ContactService;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.*;
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
    @JsonView(View.Public.class)
//    @RolesAllowed("GUEST")
    public Collection<Contact> retrieveAll()
    {
        return service.getAll();
    }

    @GET
    @Path("/{id}")
    @JsonView(View.Public.class)
//    @RolesAllowed("GUEST")
    public Contact retrieve(@PathParam("id") int id)
    {
        return service.get(id);
    }

    @GET
    @Path("/bedrijven")
    @JsonView(View.Public.class)
//    @RolesAllowed("GUEST")
    public Collection<Bedrijf> retrieveBedrijven()
    {
        return service.getBedrijven();
    }
}
