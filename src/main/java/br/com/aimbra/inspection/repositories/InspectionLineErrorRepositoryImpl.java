package br.com.aimbra.inspection.repositories;

import br.com.aimbra.inspection.entities.InspectionLineError;

public class InspectionLineErrorRepositoryImpl extends BaseRepositoryImpl<InspectionLineError> implements InspectionLineErrorRepository {

	public InspectionLineErrorRepositoryImpl() {
		super(InspectionLineError.class);
	}

}
