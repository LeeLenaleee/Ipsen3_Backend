package nl.hsleiden.service;

import nl.hsleiden.model.User;
import nl.hsleiden.persistence.LoginDao;

import javax.inject.Inject;
import java.util.Collection;

public class LoginService extends BaseService<User>{
    private final LoginDao dao;

    @Inject
    public LoginService(LoginDao dao)
    {
        this.dao = dao;
    }

    /*public Collection<User> getAll()
    {
        return dao.getAll();
    }

    public User get(int id)
    {
        return requireResult(dao.get(id));
    }

    public void add(User user)
    {
        user.setRoles(new String[] { "GUEST" });

        dao.add(user);
    }

    public void update(User authenticator, int id, User user)
    {
        // Controleren of deze gebruiker wel bestaat
        User oldUser = get(id);

        if (!authenticator.hasRole("ADMIN"))
        {
            // Vaststellen dat de geauthenticeerde gebruiker
            // zichzelf aan het aanpassen is
            assertSelf(authenticator, oldUser);
        }

        dao.update(id, user);
    }

    public void delete(int id)
    {
        // Controleren of deze gebruiker wel bestaat
        User user = get(id);

        dao.delete(id);
    }*/
}
