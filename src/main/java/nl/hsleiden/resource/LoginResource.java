package nl.hsleiden.resource;

import com.fasterxml.jackson.annotation.JsonView;
import nl.hsleiden.View;
import nl.hsleiden.model.LoginUser;
import nl.hsleiden.model.User;
import nl.hsleiden.persistence.UserDAO;
import nl.hsleiden.service.LoginService;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.Provider;
import java.util.Optional;

/**
 * @author Jacco van den Berg
 */
@Provider
@Singleton
@Path("/login")
public class LoginResource {
    private final LoginService service;
    private final UserDAO userDAO;

    @Inject
    public LoginResource(LoginService service, UserDAO userDAO) {
        this.service = service;
        this.userDAO = userDAO;
    }

    /*@GET
    @Produces(MediaType.TEXT_PLAIN)
    public String get(@QueryParam("email") Optional<String> email, @QueryParam("password") Optional<String> password) {
        String displayName;
        String testMail = "jaccoberg2281@gmail.com";
        if (email.get().equals(testMail) && password.get().equals("lol")) {
            displayName = Boolean.toString(true);
        } else {
            displayName = Boolean.toString(false);
        }

        //return "Hello " + displayName;
        return "[{\"credentials\": \"" + displayName + "\"}]";
    }*/

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @JsonView(View.Protected.class)
    public User create( LoginUser loginUser)
    {
        System.out.println(loginUser.getEmail());
        if(loginUser.getPassword().equals(this.userDAO.getByEmailAddress(loginUser.getEmail()).getPassword())){
            return this.userDAO.getByEmailAddress(loginUser.getEmail());
        }
        else {
            //TODO hier een 400 bad request returnen
            return null;
        }
    }

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @JsonView(View.Protected.class)
    public User get(@QueryParam("email") String email, @QueryParam("password") String password)
    {
        if(email.equals(this.userDAO.getByEmailAddress("first@user.com").getEmailAddress())){
            System.out.println("idk what");
            return this.userDAO.getByEmailAddress(email);
        }
        else {
            //TODO hier een 400 bad request returnen
            return null;
        }
    }

}
