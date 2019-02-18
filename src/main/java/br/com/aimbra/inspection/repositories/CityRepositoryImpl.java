package br.com.aimbra.inspection.repositories;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.aimbra.inspection.entities.City;
import br.com.aimbra.inspection.entities.FederateUnit;

public class CityRepositoryImpl extends BaseRepositoryImpl<City> implements CityRepository {

	public CityRepositoryImpl() {
		super(City.class);
	}
	
	@Override
	public City findByName(City city) {
		try {
			Query query = em.createQuery("SELECT c FROM City c WHERE c.name=:pCityName");
			query.setParameter("pCityName", city.getName());
			return (City) query.getSingleResult();				
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public boolean exist(City city) {
		TypedQuery<City> query = em.createQuery("SELECT c FROM City c WHERE c.name=:pCityName", City.class);
		
		query.setParameter("pCityName", city.getName());
		try {
			@SuppressWarnings("unused")
			City c = query.getSingleResult();
			return true;
		} catch (NoResultException ex) {
			return false;
		}
	}
	
	@Override
	public boolean existOnFederalUnit(City city, FederateUnit uf) {
		TypedQuery<City> query = em.createQuery("SELECT c FROM City c WHERE c.name=:pCityName and c.federationUnit=:puf", City.class);
		
		query.setParameter("puf", uf);
		query.setParameter("pCityName", city.getName());
		try {
			@SuppressWarnings("unused")
			City c = query.getSingleResult();
			return true;
		} catch (NoResultException ex) {
			return false;
		}
	}
	
}
