package nl.hsleiden.persistence;

import com.google.inject.Inject;
import nl.hsleiden.model.OnkostenModel;
import org.hibernate.SessionFactory;

import javax.inject.Singleton;
import java.util.List;

/**
 * @author Simon van Kouteren
 */
@Singleton
public class OnkostenDAO extends CrudFindableDAOimpl<OnkostenModel> {

    @Inject
    public OnkostenDAO(SessionFactory factory) {
        super(OnkostenModel.class, factory);
    }

    public List<OnkostenModel> findByOmschrijving(String omschrijving) {
        return super.findBy(
                (criteriaBuilder, criteriaQuery, root) ->
                        criteriaQuery.where(criteriaBuilder.like(root.get("onkostenOmschrijving"), "%" + omschrijving + "%")),
                query -> query.list()
        );
    }
}
