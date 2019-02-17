package br.com.aimbra.inspection.repositories;

import javax.persistence.Query;

import br.com.aimbra.inspection.entities.FederateUnit;

public class FederateUnitRepositoryImpl extends BaseRepositoryImpl<FederateUnit> implements FederateUnitRepository {
	
	public FederateUnitRepositoryImpl() {
		super(FederateUnit.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public FederateUnit findByInitials(FederateUnit uf) {
		try {
			Query query = em.createQuery("SELECT uf FROM FederateUnit uf WHERE uf.initials=:pUf");
			query.setParameter("pUf", uf.getInitials());
			return (FederateUnit) query.getSingleResult();				
		} catch (Exception e) {
			throw e;
		}
	}
	
}
