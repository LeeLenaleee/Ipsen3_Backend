package nl.hsleiden.persistence;

import nl.hsleiden.model.BriefModel;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;

@Singleton
public class BriefDAO extends BaseDAO<BriefModel> {

    Finder<BriefModel, BriefDAO> finder;

    @Inject
    public BriefDAO(SessionFactory sessionFactory) {
        super(BriefModel.class, sessionFactory);
        this.finder = new Finder(BriefModel.class, this);
    }

    public List<BriefModel> findByGeadreseerde(String geadreseerde) {
        return finder.findBy(
                (criteriaBuilder, criteriaQuery, root) ->
                        criteriaQuery.where(criteriaBuilder.like(root.get("betreft"), "%" + geadreseerde + "%")),
                Query::list
        );
    }
}
