package nl.hsleiden.resource;

import nl.hsleiden.service.LoginService;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
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

    @Inject
    public LoginResource(LoginService service) {
        this.service = service;
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String get(@QueryParam("email") Optional<String> email, @QueryParam("password") Optional<String> password) {
        String displayName;
        String testMail = "jaccoberg2281@gmail.com";
        System.out.println("hi"+ email.get().equals(testMail));
        String x = email.toString();
        System.out.println(testMail.equals(x));
        if (email.get().equals(testMail) && password.get().equals("lol")) {
            displayName = Boolean.toString(true);
        } else {
            displayName = Boolean.toString(false);
        }

        //return "Hello " + displayName;
        return "[{\"credentials\": \"" + displayName + "\"}]";
    }
}
