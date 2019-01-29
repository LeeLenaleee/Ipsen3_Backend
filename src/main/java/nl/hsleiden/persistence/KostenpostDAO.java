package nl.hsleiden.persistence;

import com.google.inject.Inject;
import nl.hsleiden.model.KostenpostModel;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class KostenpostDAO extends BaseDAO<KostenpostModel> {
    Finder<KostenpostModel, KostenpostDAO> finder;

    @Inject
    public KostenpostDAO(SessionFactory factory) {
        super(KostenpostModel.class, factory);
        this.finder = new Finder(KostenpostModel.class, this);
    }

    public List<KostenpostModel> findByName(String name) {
        return this.finder.findBy(
                (criteriaBuilder, criteriaQuery, root) ->
                        criteriaQuery.where(criteriaBuilder.like(root.get("kostenpost"), "%" + name + "%")),
                Query::list
        );
    }
}
