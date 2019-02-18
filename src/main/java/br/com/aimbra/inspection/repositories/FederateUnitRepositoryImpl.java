package br.com.aimbra.inspection.repositories;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.aimbra.inspection.entities.FederateUnit;

public class FederateUnitRepositoryImpl extends BaseRepositoryImpl<FederateUnit> implements FederateUnitRepository {
	
	public FederateUnitRepositoryImpl() {
		super(FederateUnit.class);
	}

	@Override
	public FederateUnit findByInitials(FederateUnit uf) {
		try {
			em.getTransaction().begin();
			Query query = em.createQuery("SELECT uf FROM FederateUnit uf WHERE uf.initials=:pUf");
			query.setParameter("pUf", uf.getInitials());
			uf = (FederateUnit) query.getSingleResult();				
			em.getTransaction().commit();
			return uf;
		} catch (Exception e) {
			em.getTransaction().rollback();
		} finally {
			em.close();			
		}
		return null;
	}
	
	@Override
	public boolean exist(FederateUnit uf) {
		em.getTransaction().begin();
		TypedQuery<FederateUnit> query = em.createQuery(
				  " select uf from FederateUnit uf "
				+ " where uf.name = :pUfName or uf.initials = :pUfInitials", FederateUnit.class);
		
		query.setParameter("pUfInitials", uf.getInitials());
		query.setParameter("pUfName", uf.getName());
		try {
			@SuppressWarnings("unused")
			FederateUnit resultado = query.getSingleResult();
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
