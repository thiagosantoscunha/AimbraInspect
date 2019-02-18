package br.com.aimbra.inspection.repositories;

import br.com.aimbra.inspection.entities.Inspection;

public class InspectionRepositoryImpl extends BaseRepositoryImpl<Inspection> implements InspectionRepository {

	public InspectionRepositoryImpl() {
		super(Inspection.class);
	}
	
}
