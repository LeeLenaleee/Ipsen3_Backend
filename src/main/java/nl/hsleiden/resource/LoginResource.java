package nl.hsleiden.resource;

import com.fasterxml.jackson.annotation.JsonView;
import io.dropwizard.hibernate.UnitOfWork;
import nl.hsleiden.View;
import nl.hsleiden.model.LoginGebruikerModel;
import nl.hsleiden.model.GebruikerModel;
import nl.hsleiden.persistence.UserDAO;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.Provider;
/**
 * @author Jacco van den Berg
 */
@Provider
@Singleton
@Path("/login")
public class LoginResource {
    private final UserDAO userDAO;

    @Inject
    public LoginResource(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @POST
    @UnitOfWork
    @Consumes(MediaType.APPLICATION_JSON)
    @JsonView(View.Protected.class)
    public GebruikerModel create(LoginGebruikerModel loginGebruikerModel)
    {
        System.err.println(this.userDAO.getByEmailAddress(loginGebruikerModel.getEmail()).get(0));
        if(loginGebruikerModel.getPassword().equals(this.userDAO.getByEmailAddress(loginGebruikerModel.getEmail()).get(0).getPassword())){
            return this.userDAO.getByEmailAddress(loginGebruikerModel.getEmail()).get(0);
        }
        else {
            throw new NotAuthorizedException("Login Credentials are wrong");
        }
    }

}
