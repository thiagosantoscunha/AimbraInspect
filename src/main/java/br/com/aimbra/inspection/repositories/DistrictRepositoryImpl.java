package br.com.aimbra.inspection.repositories;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;
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
			TypedQuery<District> query = em.createQuery("SELECT d FROM District d WHERE d.name=:pDistrictName", District.class);
			query.setParameter("pDistrictName", district.getName());
			return (District) query.getSingleResult();				
		} catch (Exception e) {
			throw e;
		}
	}
	
	

	@Override
	public boolean exist(District district) {
		TypedQuery<District> query = em.createQuery("SELECT d FROM District d WHERE d.name=:pDistrictName", District.class);
		query.setParameter("pDistrictName", district.getName());
		try {
			@SuppressWarnings("unused")
			List<District> ds = query.getResultList();
			return true;
		} catch (NoResultException ex) {
			return false;
		}
	}

	@Override
	public District findByNameAndCity(District district, City city) {
		try {
			TypedQuery<District> query = em.createQuery("SELECT d FROM District d WHERE d.name=:pDistrict and d.city=:pCityId", District.class);
			query.setParameter("pDistrict", district.getName());
			query.setParameter("pCityId", city);
			return query.getSingleResult();				
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public boolean existOnCity(District district, City city) {
		TypedQuery<District> query = em.createQuery("SELECT d FROM District d WHERE d.name = :pDistrictName and d.city=:pCity", District.class);
		query.setParameter("pDistrictName", district.getName());
		query.setParameter("pCity", city);
		try {
			@SuppressWarnings("unused")
			District ds = query.getSingleResult();
			return true;
		} catch (NoResultException ex) {
			return false;
		}
	}

}
