package br.com.aimbra.inspection.repositories;

import javax.persistence.EntityManager;

import br.com.aimbra.inspection.entities.Inspection;

public class InspectionRepositoryImpl extends BaseRepositoryImpl<Inspection> implements InspectionRepository {

	public InspectionRepositoryImpl(EntityManager em) {
		super(Inspection.class, em);
	}
	
}
