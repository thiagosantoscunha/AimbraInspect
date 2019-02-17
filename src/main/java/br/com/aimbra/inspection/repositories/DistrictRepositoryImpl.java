package br.com.aimbra.inspection.repositories;

import javax.persistence.Query;

import br.com.aimbra.inspection.entities.District;

public class DistrictRepositoryImpl extends BaseRepositoryImpl<District> implements DistrictRepository {

	public DistrictRepositoryImpl() {
		super(District.class);
	}

	@Override
	public District findByName(District district) {
		try {
			Query query = em.createQuery("SELECT d FROM District d WHERE d.name=:pDistrictName");
			query.setParameter("pDistrictName", district.getName());
			return (District) query.getSingleResult();				
		} catch (Exception e) {
			throw e;
		}
	}

}
