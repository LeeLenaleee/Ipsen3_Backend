package nl.hsleiden.persistence;

import java.util.List;
import javax.inject.Singleton;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.google.inject.Inject;
import nl.hsleiden.model.GebruikerModel;
import org.hibernate.SessionFactory;

/**
 *
 * @author Jacco van den Berg
 */
@Singleton
public class UserDAO extends BaseDAO<GebruikerModel>
{
    @Inject
    public UserDAO(SessionFactory factory) {
        super(GebruikerModel.class, factory);
    }

    public List<GebruikerModel> getByEmailAddress(String email) {

        TriFunction<CriteriaBuilder, CriteriaQuery<?>, Root<?>> anon = new TriFunction<CriteriaBuilder, CriteriaQuery<?>, Root<?>>() {
            @Override
            public void apply(CriteriaBuilder criteriaBuilder, CriteriaQuery<?> criteriaQuery, Root<?> root) {
                criteriaQuery.where(criteriaBuilder.like(root.get("emailAddress"), "%" + email + "%"));
            }
        };

        return super.findBy(anon);
    }
}