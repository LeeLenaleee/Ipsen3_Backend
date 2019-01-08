package nl.hsleiden.persistence;

import nl.hsleiden.model.GebruikerModel;
import org.hibernate.SessionFactory;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Singleton
public class GebruikerDAO extends BaseDAO<GebruikerModel>
{
    @Inject
    public GebruikerDAO(SessionFactory factory) {
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
