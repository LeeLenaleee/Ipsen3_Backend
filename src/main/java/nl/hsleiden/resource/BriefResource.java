package nl.hsleiden.resource;

import io.dropwizard.hibernate.UnitOfWork;
import nl.hsleiden.model.BriefModel;
import nl.hsleiden.service.BriefService;
import nl.hsleiden.utility.PDFWriter;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.File;

@Singleton
@Path("/brief")
@Produces(MediaType.APPLICATION_JSON)
public class BriefResource {
    private final BriefService briefService;

    @Inject
    public BriefResource(BriefService briefService){this.briefService = briefService;}

    @Path("/download")
    @GET
    @UnitOfWork
    @Produces({"application/pdf"})
    public File getFile(@QueryParam("id") int id) {
        return PDFWriter.maakBrief(this.briefService.findById(id));
    }

    @Path("/json")
    @GET
    @UnitOfWork
    @Produces(MediaType.APPLICATION_JSON)
    public BriefModel getJson(@QueryParam("id") int id) {
        return this.briefService.findById(id);
    }

    @Path("/insert")
    @POST
    @UnitOfWork
    @Consumes(MediaType.APPLICATION_JSON)
    public void voegToe(BriefModel briefModel){
        this.briefService.create(briefModel);
    }

    @Path("/update")
    @POST
    @UnitOfWork
    @Consumes(MediaType.APPLICATION_JSON)
    public void update(BriefModel briefModel){
        this.briefService.update(briefModel, briefModel.getId());
    }

    @Path("/delete")
    @POST
    @UnitOfWork
    @Consumes(MediaType.APPLICATION_JSON)
    public void delete(BriefModel briefModel){
        this.briefService.delete(briefModel);
    }
}
