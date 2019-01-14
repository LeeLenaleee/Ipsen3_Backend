package nl.hsleiden.persistence;

import com.google.inject.Singleton;
import nl.hsleiden.model.BaseModel;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@Singleton
public interface FindableDAO<M extends BaseModel> extends BasicDAO<M> {
    public <R> R findBy(TriFunction<CriteriaBuilder, CriteriaQuery<?>, Root<?>> buildQuery, QueryExtractor<M, R> extractor);
}