package br.com.aimbra.inspection.repositories;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.aimbra.inspection.entities.FederateUnit;

public class FederateUnitRepositoryImpl extends BaseRepositoryImpl<FederateUnit> implements FederateUnitRepository {


	public FederateUnitRepositoryImpl(EntityManager em) {
		super(FederateUnit.class, em);
	}

	@Override
	public FederateUnit findByInitials(String initials) {
		TypedQuery<FederateUnit> query = em.createQuery("SELECT uf FROM FederateUnit uf WHERE uf.initials=:pUf", FederateUnit.class);
		query.setParameter("pUf", initials);
		return query.getSingleResult();
	}

	@Override
	public boolean exist(FederateUnit uf) {
		TypedQuery<FederateUnit> query = em.createQuery(
				"SELECT uf FROM FederateUnit uf WHERE uf.name = :pUfName or uf.initials = :pUfInitials",
				FederateUnit.class);
		query.setParameter("pUfInitials", uf.getInitials());
		query.setParameter("pUfName", uf.getName());
		try {
			return query.getSingleResult() != null;
		} catch (NoResultException ex) {
			return false;
		}
		
	}

}
