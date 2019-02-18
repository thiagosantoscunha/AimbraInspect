package br.com.aimbra.inspection.repositories;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import br.com.aimbra.inspection.entities.City;
import br.com.aimbra.inspection.entities.District;

public class DistrictRepositoryImpl extends BaseRepositoryImpl<District> implements DistrictRepository {

	public DistrictRepositoryImpl() {
		super(District.class);
	}

	
	@Override
	public District findByName(District district) {
		try {
			em.getTransaction().begin();
			TypedQuery<District> query = em.createQuery("SELECT d FROM District d WHERE d.name=:pDistrictName", District.class);
			query.setParameter("pDistrictName", district.getName());
			district = (District) query.getSingleResult();
			em.getTransaction().commit();
			return district;
		} catch (Exception e) {
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
		return null;
	}
	
	

	@Override
	public boolean exist(District district) {
		em.getTransaction().begin();
		TypedQuery<District> query = em.createQuery("SELECT d FROM District d WHERE d.name=:pDistrictName", District.class);
		query.setParameter("pDistrictName", district.getName());
		try {
			@SuppressWarnings("unused")
			List<District> ds = query.getResultList();
			em.getTransaction().commit();
			return true;
		} catch (NoResultException ex) {
			em.getTransaction().rollback();
			return false;
		} finally {
			em.close();
		}
	}

	@Override
	public District findByNameAndCity(District district, City city) {
		try {
			em.getTransaction().begin();
			TypedQuery<District> query = em.createQuery("SELECT d FROM District d WHERE d.name=:pDistrict and d.city=:pCityId", District.class);
			query.setParameter("pDistrict", district.getName());
			query.setParameter("pCityId", city);
			district = query.getSingleResult();
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
		return null;
	}

	@Override
	public boolean existOnCity(District district, City city) {
		em.getTransaction().begin();
		TypedQuery<District> query = em.createQuery("SELECT d FROM District d WHERE d.name = :pDistrictName and d.city=:pCity", District.class);
		query.setParameter("pDistrictName", district.getName());
		query.setParameter("pCity", city);
		try {
			@SuppressWarnings("unused")
			District ds = query.getSingleResult();
			em.getTransaction().commit();
			return true;
		} catch (NoResultException ex) {
			em.getTransaction().rollback();
			return false;
		} finally {
			em.close();
		}
	}

}
