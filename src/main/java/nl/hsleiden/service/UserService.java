package nl.hsleiden.service;

import javax.inject.Inject;
import javax.inject.Singleton;
import nl.hsleiden.model.GebruikerModel;
import nl.hsleiden.persistence.UserDAO;

/**
 *
 * @author Peter van Vliet
 */
@Singleton
public class UserService extends BaseService<GebruikerModel,UserDAO>
{
    @Inject
    public UserService(UserDAO dao)
    {
        super(dao);
    }
}