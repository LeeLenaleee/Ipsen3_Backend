package nl.hsleiden.persistence;

import nl.hsleiden.model.FactuurModel;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import javax.inject.Inject;
import java.util.List;

public class FactuurDAO extends BaseDAO<FactuurModel> {
    Finder<FactuurModel, FactuurDAO> finder;

    @Inject
    public FactuurDAO(SessionFactory sessionFactory) {
        super(FactuurModel.class, sessionFactory);

        this.finder = new Finder(FactuurModel.class, this);
    }

    public List<FactuurModel> findByOmschrijving(String omschrijving) {
        return this.finder.findBy(
                (criteriaBuilder, criteriaQuery, root) ->
                        criteriaQuery.where(criteriaBuilder.like(root.get("factuurOmschrijving"), "%" + omschrijving + "%")),
                Query::list
        );
    }

}
