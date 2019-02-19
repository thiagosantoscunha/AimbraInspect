package br.com.aimbra.inspection.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;

public abstract class BaseRepositoryImpl<T> implements BaseRepository<T> {

	protected EntityManager em;
	private final Class<T> entity;

	public BaseRepositoryImpl(Class<T> entity, EntityManager em) {
		this.em = em;
		this.entity = entity;
	}

	@Override
	public List<T> findAll() {
		CriteriaQuery<T> query = em.getCriteriaBuilder().createQuery(entity);
		query.select(query.from(entity));
		List<T> list = em.createQuery(query).getResultList();
		return list;
	}

	@Override
	public T findById(Long id) {
		T t = em.find(entity, id);
		return t;
	}

	@Override
	public T create(T t) {
		em.persist(t);
		return t;
	}

	@Override
	public T update(T t) {
		em.merge(t);
		return t;
	}

	@Override
	public T delete(T t) {
		T tAux = t;
		em.remove(em.merge(t));
		return tAux;
	}

}
