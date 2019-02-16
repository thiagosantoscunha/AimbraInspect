package br.com.aimbra.inspection.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.aimbra.inspection.connection.JPAUtil;

public class BaseRepositoryImpl<T> implements BaseRepository<T> {
	
	EntityManager em;
	
	public BaseRepositoryImpl() {
		em = JPAUtil.getEntityManager();
	}
	
	@Override
	public List<T> findAll() {
		em.getTransaction().begin();
		Query query = em.createQuery("SELECT t FROM T t");
		em.getTransaction().commit();
		return (List<T>) query.getResultList();
	}

	@Override
	public T findById(Long id) {
//		em.getTransaction().begin();
//		T t = em.find(Class<T>, id);
//		em.getTransaction().commit();
		return null;
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
		return t;
	}

	@Override
	public T delete(T t) {
		// TODO Auto-generated method stub
		return t;
	}

	@Override
	public boolean exist(T t) {
		// TODO Auto-generated method stub
		return false;
	}

}
