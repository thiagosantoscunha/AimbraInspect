package br.com.aimbra.inspection.repositories;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import br.com.aimbra.inspection.entities.City;
import br.com.aimbra.inspection.entities.District;

public class DistrictRepositoryImpl extends BaseRepositoryImpl<District> implements DistrictRepository {


	public DistrictRepositoryImpl(EntityManager em) {
		super(District.class, em);
	}

	@Override
	public District findByName(String name) {
		try {
			TypedQuery<District> query = em.createQuery("SELECT d FROM District d WHERE d.name=:pDistrictName", District.class);
			query.setParameter("pDistrictName", name);
			return query.getSingleResult();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	@Override
	public District findByNameOnCity(String name, City city) {
		try {
			TypedQuery<District> query = em.createQuery("SELECT d FROM District d WHERE d.name=:pDistrict and d.city=:pCityId", District.class);
			query.setParameter("pDistrict", name);
			query.setParameter("pCityId", city);
			return query.getSingleResult();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	@Override
	public boolean exist(String name) {
		return (this.findByName(name) != null);
	}

	@Override
	public boolean existOnCity(String name, City city) {
		TypedQuery<District> query = em.createQuery("SELECT d FROM District d WHERE d.name = :pDistrictName and d.city=:pCity", District.class);
		query.setParameter("pDistrictName", name);
		query.setParameter("pCity", city);
		try {
			return query.getSingleResult() != null;
		} catch (NoResultException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

}
