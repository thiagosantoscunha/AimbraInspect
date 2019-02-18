package br.com.aimbra.inspection.repositories;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import br.com.aimbra.inspection.entities.FederateUnit;
import br.com.aimbra.inspection.entities.Inspection;

public class InspectionRepositoryImpl extends BaseRepositoryImpl<Inspection> implements InspectionRepository {

	public InspectionRepositoryImpl() {
		super(Inspection.class);
	}
	
//	@Override
//	public boolean exist(Inspection inspection) {
//		TypedQuery<Inspection> query = em.createQuery(
//				  " select i from Inspection i "
//				+ " where i.name = :pName or i.initials = :pInitials", Inspection.class);
//		
//		query.setParameter("pUfInitials", uf.getInitials());
//		query.setParameter("pUfName", uf.getName());
//		try {
//			@SuppressWarnings("unused")
//			FederateUnit resultado = query.getSingleResult();
//			return true;
//		} catch (NoResultException ex) {
//			return false;
//		}
//	}

}
