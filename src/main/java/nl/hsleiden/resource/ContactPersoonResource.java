package nl.hsleiden.resource;

import com.fasterxml.jackson.annotation.JsonView;
import com.google.inject.Singleton;
import io.dropwizard.hibernate.UnitOfWork;
import nl.hsleiden.View;
import nl.hsleiden.model.ContactPersoonModel;
import nl.hsleiden.persistence.ContactPersoonDAO;
import nl.hsleiden.service.ContactPersoonService;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Singleton
@Path("/contacten")
@RolesAllowed("user")
public class ContactPersoonResource extends BaseResource<ContactPersoonModel, ContactPersoonDAO, ContactPersoonService> {

    @Inject
    public ContactPersoonResource(ContactPersoonService service) {
        super(service);
    }

    @GET
    @Path("/bedrijf")
    @UnitOfWork
    @JsonView(View.Protected.class)
    @Produces(MediaType.APPLICATION_JSON)
    public List<ContactPersoonModel> findByBedrijf(@QueryParam("bedrijf") String bedrijf) {
        List<ContactPersoonModel> results = service.findByBedrijf(bedrijf);

        // Didn't find any matches.
        if (results.isEmpty()) {
            throw new NotFoundException();
        }

        return results;
    }

    @GET
    @Path("/naam")
    @UnitOfWork
    @JsonView(View.Protected.class)
    @Produces(MediaType.APPLICATION_JSON)
    public List<ContactPersoonModel> findByNaam(@QueryParam("voornaam") String voornaam, @QueryParam("achternaam") String achternaam) {
        List<ContactPersoonModel> results = service.findByNaam(voornaam, achternaam);

        // Didn't find any matches.
        if (results.isEmpty()) {
            throw new NotFoundException();
        }

        return results;
    }
}