package br.com.aimbra.inspection.business;

import java.util.List;

import br.com.aimbra.inspection.entities.FederateUnit;

public interface FederateUnitService {
	List<FederateUnit> findAll();
	FederateUnit findById(Long id);
	FederateUnit create(FederateUnit federateUnit);
	FederateUnit update(FederateUnit federateUnit);
	FederateUnit delete(FederateUnit federateUnit);
}
