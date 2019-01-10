package nl.hsleiden.persistence;

import com.google.inject.Inject;
import nl.hsleiden.model.OnkostenModel;
import org.hibernate.SessionFactory;

import javax.inject.Singleton;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * @author Simon van Kouteren
 */
@Singleton
public class OnkostenDAO extends BaseDAO<OnkostenModel> {

    @Inject
    public OnkostenDAO(SessionFactory factory) {
        super(OnkostenModel.class, factory);
    }

    public List<OnkostenModel> findByOmschrijving(String omschrijving) {

        TriFunction<CriteriaBuilder, CriteriaQuery<?>, Root<?>> build_query = new TriFunction<CriteriaBuilder, CriteriaQuery<?>, Root<?>>() {
            @Override
            public void apply(CriteriaBuilder criteriaBuilder, CriteriaQuery<?> criteriaQuery, Root<?> root) {
                criteriaQuery.where(criteriaBuilder.like(root.get("onkostenOmschrijving"), "%" + omschrijving + "%"));
            }
        };

        return super.findBy(build_query);
    }
}
