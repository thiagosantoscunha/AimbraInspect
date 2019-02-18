package br.com.aimbra.inspection.repositories;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

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
	
	@Override
	public boolean exist(FederateUnit uf) {
		TypedQuery<FederateUnit> query = em.createQuery(
				  " select uf from FederateUnit uf "
				+ " where uf.name = :pUfName or uf.initials = :pUfInitials", FederateUnit.class);
		
		query.setParameter("pUfInitials", uf.getInitials());
		query.setParameter("pUfName", uf.getName());
		try {
			@SuppressWarnings("unused")
			FederateUnit resultado = query.getSingleResult();
			return true;
		} catch (NoResultException ex) {
			return false;
		}
	}
	
}
