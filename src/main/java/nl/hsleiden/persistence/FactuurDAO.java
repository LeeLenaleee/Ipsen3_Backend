package nl.hsleiden.persistence;

import nl.hsleiden.model.FactuurModel;
import org.hibernate.SessionFactory;

import javax.inject.Inject;
import java.util.List;

public class FactuurDAO extends CrudFindableDAOimpl<FactuurModel> {
    @Inject
    public FactuurDAO(SessionFactory sessionFactory) {
        super(FactuurModel.class, sessionFactory);
    }

    public List<FactuurModel> findByOmschrijving(String omschrijving) {
        return super.findBy(
                (criteriaBuilder, criteriaQuery, root) ->
                        criteriaQuery.where(criteriaBuilder.like(root.get("factuurOmschrijving"), "%" + omschrijving + "%")),
                query -> query.list()
        );
    }
}
