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
			em.getTransaction().begin();
			
			Query query = em.createQuery("SELECT c FROM City c WHERE c.name=:pCityName");
			query.setParameter("pCityName", city.getName());
			city = (City) query.getSingleResult();
			
			em.getTransaction().commit();
			return city;
		} catch(Exception ex) {
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
		return null;
	}

	@Override
	public boolean exist(City city) {
		em.getTransaction().begin();
		
		TypedQuery<City> query = em.createQuery("SELECT c FROM City c WHERE c.name=:pCityName", City.class);
		query.setParameter("pCityName", city.getName());
		
		try {
			@SuppressWarnings("unused")
			City c = query.getSingleResult();
			em.getTransaction().commit();
			return true;
		} catch (NoResultException ex) {
			return false;
		} finally {
			em.close();
		}
	}
	
	@Override
	public boolean existOnFederalUnit(City city, FederateUnit uf) {
		em.getTransaction().begin();
		
		TypedQuery<City> query = em.createQuery("SELECT c FROM City c WHERE c.name=:pCityName and c.federationUnit=:puf", City.class);
		query.setParameter("puf", uf);
		query.setParameter("pCityName", city.getName());
		
		try {
			@SuppressWarnings("unused")
			City c = query.getSingleResult();
			em.getTransaction().commit();
			return true;
		} catch (NoResultException ex) {
			return false;
		}
	}
	
}
