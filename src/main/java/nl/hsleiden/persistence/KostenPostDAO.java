package nl.hsleiden.persistence;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import nl.hsleiden.model.KostenpostModel;
import org.hibernate.SessionFactory;

import java.util.List;

@Singleton
public class KostenPostDAO extends CrudFindableDAOimpl<KostenpostModel> {
    @Inject
    public KostenPostDAO(SessionFactory factory) {
        super(KostenpostModel.class, factory);
    }

    public List<KostenpostModel> findByName(String name) {
        return super.findBy(
                (criteriaBuilder, criteriaQuery, root) ->
                        criteriaQuery.where(criteriaBuilder.like(root.get("kostenpost"), "%" + name + "%")),
                query -> query.list()
        );
    }
}
