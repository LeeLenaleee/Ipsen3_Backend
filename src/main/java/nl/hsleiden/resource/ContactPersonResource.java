package nl.hsleiden.resource;

import javax.inject.Inject;

import com.fasterxml.jackson.annotation.JsonView;
import com.google.inject.Singleton;
import nl.hsleiden.View;
import nl.hsleiden.model.ContactPerson;
import nl.hsleiden.service.ContactactService;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Singleton
@Path("/contacts")
@Produces(MediaType.APPLICATION_JSON)
public class ContactPersonResource {
    private final ContactactService service;

    @Inject
    public ContactPersonResource(ContactactService service)
    {
        this.service = service;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @JsonView(View.Public.class)
    public void create(@Valid ContactPerson contactPerson)
    {
        service.add(contactPerson);
    }
}
