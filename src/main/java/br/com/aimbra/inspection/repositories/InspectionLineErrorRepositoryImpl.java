package br.com.aimbra.inspection.repositories;

import javax.persistence.EntityManager;

import br.com.aimbra.inspection.entities.InspectionLineError;

public class InspectionLineErrorRepositoryImpl extends BaseRepositoryImpl<InspectionLineError> implements InspectionLineErrorRepository {

	public InspectionLineErrorRepositoryImpl(EntityManager em) {
		super(InspectionLineError.class, em);
	}

}
