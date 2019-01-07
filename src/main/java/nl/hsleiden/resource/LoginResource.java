package nl.hsleiden.resource;

import com.fasterxml.jackson.annotation.JsonView;
import nl.hsleiden.View;
import nl.hsleiden.model.LoginUser;
import nl.hsleiden.model.User;
import nl.hsleiden.persistence.UserDAO;
import nl.hsleiden.service.LoginService;

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
    private final LoginService service;
    private final UserDAO userDAO;

    @Inject
    public LoginResource(LoginService service, UserDAO userDAO) {
        this.service = service;
        this.userDAO = userDAO;
    }

    /**
     *
     * @param loginUser
     * @return user or a not authorized exception
     */
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
            throw new NotAuthorizedException("Login Credentials are wrong");
        }
    }


}
