package br.com.aimbra.inspection.repositories;

import javax.persistence.Query;

import br.com.aimbra.inspection.entities.City;

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
	
}
