package br.com.aimbra.inspection.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

import br.com.aimbra.inspection.connection.JPAUtil;

public abstract class BaseRepositoryImpl<T> implements BaseRepository<T> {
	
	protected EntityManager em;
	private final Class<T> entity;
	
	public BaseRepositoryImpl(Class<T> entity) {
		em = JPAUtil.getEntityManager();
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
		return em.find(entity, id);
	}

	@Override
	public T create(T t) {
		try {
			em.getTransaction().begin();
			em.persist(t);
			em.getTransaction().commit();
			return t;
		} catch(Exception ex) {
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
		return null;
	}

	@Override
	public T update(T t) {
		em.merge(t);
		return t;
	}

	@Override
	public T delete(T t) {
		em.remove(em.merge(t));
		return t;
	}

}
