package nl.hsleiden.persistence;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.inject.Singleton;
import nl.hsleiden.model.User;

/**
 *
 * @author Peter van Vliet
 */
@Singleton
public class UserDAO
{
    private final List<User> users;
    
    public UserDAO()
    {
        User user1 = new User();
        user1.setFullName("First user");
        user1.setPostcode("1234AB");
        user1.setStreetnumber("12");
        user1.setEmailAddress("first@user.com");
        user1.setPassword("8b04d5e3775d298e78455efc5ca404d5");
        user1.setRoles(new String[] { "GUEST", "ADMIN" });
        
        User user2 = new User();
        user2.setFullName("Second user");
        user2.setPostcode("9876ZY");
        user2.setStreetnumber("98");
        user2.setEmailAddress("second@user.com");
        user2.setPassword("a9f0e61a137d86aa9db53465e0801612");
        user2.setRoles(new String[] { "GUEST" });

        User user3 = new User();
        user3.setFullName("Jacco van den Berg");
        user3.setPostcode("2568PC");
        user3.setStreetnumber("88");
        user3.setEmailAddress("jaccoberg2281@gmail.com");
        user3.setPassword("b4453d1f9f5386a1846e57a3ec95678f");
        user1.setRoles(new String[] { "GUEST", "ADMIN" });
        
        users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        users.add(user3);
    }
    
    public List<User> getAll()
    {
        return users;
    }
    
    public User get(int id)
    {
        try
        {
            return users.get(id);
        }
        catch(IndexOutOfBoundsException exception)
        {
            return null;
        }
    }
    
    public User getByEmailAddress(String emailAddress)
    {
        Optional<User> result = users.stream()
            .filter(user -> user.getEmailAddress().equals(emailAddress))
            .findAny();
        
        return result.isPresent()
            ? result.get()
            : null;
    }
    
    public void add(User user)
    {
        users.add(user);
    }
    
    public void update(int id, User user)
    {
        users.set(id, user);
    }
    
    public void delete(int id)
    {
        users.remove(id);
    }
}
