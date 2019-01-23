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
public class OnkostenDAO extends BaseDAO<OnkostenModel> {
    Finder<OnkostenModel, OnkostenDAO> finder;

    @Inject
    public OnkostenDAO(SessionFactory factory) {
        super(OnkostenModel.class, factory);
        this.finder = new Finder(OnkostenModel.class, this);
    }

    public List<OnkostenModel> findByOmschrijving(String omschrijving) {
        return this.finder.findBy(
                (criteriaBuilder, criteriaQuery, root) ->
                        criteriaQuery.where(criteriaBuilder.like(root.get("onkostenOmschrijving"), "%" + omschrijving + "%")),
                query -> query.list()
        );
    }
}
