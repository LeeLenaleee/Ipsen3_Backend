package nl.hsleiden;

import com.google.inject.Module;
import com.hubspot.dropwizard.guice.GuiceBundle;
import com.hubspot.dropwizard.guice.GuiceBundle.Builder;
import io.dropwizard.Application;
import io.dropwizard.ConfiguredBundle;
import io.dropwizard.auth.AuthDynamicFeature;
import io.dropwizard.auth.AuthValueFactoryProvider;
import io.dropwizard.auth.basic.BasicCredentialAuthFilter;
import io.dropwizard.bundles.assets.ConfiguredAssetsBundle;
import io.dropwizard.forms.MultiPartBundle;
import io.dropwizard.hibernate.UnitOfWorkAwareProxyFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import nl.hsleiden.model.GebruikerModel;
import nl.hsleiden.persistence.AuthDAO;
import nl.hsleiden.service.AuthService;
import org.eclipse.jetty.servlet.FilterHolder;
import org.eclipse.jetty.servlets.CrossOriginFilter;
import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import java.util.EnumSet;

/**
 * @author Peter van Vliet
 */
public class ApiApplication extends Application<ApiConfiguration> {
    private final Logger logger = LoggerFactory.getLogger(ApiApplication.class);

    private ConfiguredBundle assetsBundle;
    private GuiceBundle guiceBundle;
    private ApiGuiceModule apiGuiceModule;
    private String name;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void initialize(Bootstrap<ApiConfiguration> bootstrap) {
//        assetsBundle = (ConfiguredBundle) new ConfiguredAssetsBundle("/assets/", "/client", "index.html");
//        guiceBundle = createGuiceBundle(ApiConfiguration.class, new ApiGuiceModule(bootstrap));
//
//        bootstrap.addBundle(assetsBundle);
//        bootstrap.addBundle(guiceBundle);

        assetsBundle = new ConfiguredAssetsBundle("/assets/", "/client", "index.html");

        apiGuiceModule = new ApiGuiceModule(bootstrap);
        guiceBundle = createGuiceBundle(ApiConfiguration.class, apiGuiceModule);

        bootstrap.addBundle(assetsBundle);
        bootstrap.addBundle(guiceBundle);

        bootstrap.addBundle(new MultiPartBundle());


    }

    @Override
    public void run(ApiConfiguration configuration, Environment environment) {
        name = configuration.getApiName();

        logger.info(String.format("Set API name to %s", name));

        setupAuthentication(environment);
        configureClientFilter(environment);
        enableCorsHeaders(environment);
    }

    private void enableCorsHeaders(Environment environment) {
        final FilterRegistration.Dynamic filter = environment.servlets().addFilter("CORS", CrossOriginFilter.class);

        filter.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), true, "/*");
        filter.setInitParameter("allowedOrigins", "http://localhost:4200");    // hier het server ip invullen waar angular op draait, kan meerdere ips doen door comma gescheiden
        filter.setInitParameter("allowedHeaders", "X-Requested-With,Content-Type,Accept,Origin");
        filter.setInitParameter("allowedMethods", "GET,PUT,POST,DELETE,OPTIONS");
        filter.setInitParameter("preflightMaxAge", "5184000"); // 2 months
        filter.setInitParameter("allowCredentials", "true");
    }

    private GuiceBundle createGuiceBundle(Class<ApiConfiguration> configurationClass, Module module) {
        Builder guiceBuilder = GuiceBundle.<ApiConfiguration>newBuilder()
                .addModule(module)
                .enableAutoConfig(new String[]{"nl.hsleiden"})
                .setConfigClass(configurationClass);

        return guiceBuilder.build();
    }

    private void setupAuthentication(Environment environment) {
        AuthDAO authDAO = guiceBundle.getInjector().getInstance(AuthDAO.class);
        ApiUnauthorizedHandler unauthorizedHandler = guiceBundle.getInjector().getInstance(ApiUnauthorizedHandler.class);

        // @NOTE:
        // This creates the authenticator,
        // which requires we pass in *ALL* attributes of the authenticator.
        AuthService authenticator = new UnitOfWorkAwareProxyFactory(apiGuiceModule.getHibernateBundle())
                .create(AuthService.class, AuthDAO.class, authDAO);

        environment.jersey().register(new AuthDynamicFeature(
                new BasicCredentialAuthFilter.Builder<GebruikerModel>()
                        .setAuthenticator(authenticator)
                        .setAuthorizer(authenticator)
                        .setRealm("SUPER SECRET STUFF")
                        .setUnauthorizedHandler(unauthorizedHandler)
                        .buildAuthFilter()));

        environment.jersey().register(RolesAllowedDynamicFeature.class);
        environment.jersey().register(new AuthValueFactoryProvider.Binder<>(GebruikerModel.class));
    }


    private void configureClientFilter(Environment environment) {
        environment.getApplicationContext().addFilter(
                new FilterHolder(new ClientFilter()),
                "/*",
                EnumSet.allOf(DispatcherType.class)
        );
    }

    public static void main(String[] args) {
        if (args.length == 0) {
            args = new String[]{"server", "configuration.yml"};
        }

        try {
            new ApiApplication().run(args);
        } catch (Exception e) {
            System.err.println(e.getStackTrace());
        }
    }
}
