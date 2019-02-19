package br.com.aimbra.inspection.repositories;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.aimbra.inspection.entities.City;
import br.com.aimbra.inspection.entities.FederateUnit;

public class CityRepositoryImpl extends BaseRepositoryImpl<City> implements CityRepository {

	public CityRepositoryImpl(EntityManager em) {
		super(City.class, em);
	}

	@Override
	public City findByName(String name) {
		try {
			TypedQuery<City> query = em.createQuery("SELECT c FROM City c WHERE c.name=:pCityName", City.class);
			query.setParameter("pCityName", name);
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
	public boolean existOnFederalUnit(String name, FederateUnit uf) {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT c FROM City c ");
		sb.append("WHERE ");
		sb.append("   c.name = :pCityName");
		sb.append("   and c.federationUnit = :puf");
		TypedQuery<City> query = em.createQuery(sb.toString(), City.class);
		query.setParameter("puf", uf);
		query.setParameter("pCityName", name);
		try {
			return (query.getSingleResult() != null);
		} catch (NoResultException ex) {
			return false;
		}
	}

}
