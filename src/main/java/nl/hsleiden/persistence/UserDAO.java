package nl.hsleiden.persistence;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.inject.Singleton;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.ws.rs.NotFoundException;

import com.google.inject.Inject;
import nl.hsleiden.model.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Peter van Vliet
 */
@Singleton
public class UserDAO extends BaseDAO<User>
{
    @Inject
    public UserDAO(SessionFactory factory) {
        super(User.class, factory);
    }

    public List<User> getByEmailAddress(String email) {

        TriFunction<CriteriaBuilder, CriteriaQuery<?>, Root<?>> anon = new TriFunction<CriteriaBuilder, CriteriaQuery<?>, Root<?>>() {
            @Override
            public void apply(CriteriaBuilder criteriaBuilder, CriteriaQuery<?> criteriaQuery, Root<?> root) {
                criteriaQuery.where(criteriaBuilder.like(root.get("emailAddress"), "%" + email + "%"));
            }
        };

        return super.findBy(anon);
    }
}
