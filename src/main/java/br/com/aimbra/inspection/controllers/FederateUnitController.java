package br.com.aimbra.inspection.controllers;

import java.util.List;

import br.com.aimbra.inspection.business.FederateUnitService;
import br.com.aimbra.inspection.business.FederateUnitServiceImpl;
import br.com.aimbra.inspection.entities.FederateUnit;

public class FederateUnitController {
	
	private FederateUnitService federateUnitService;

	public FederateUnitController() {
		this.federateUnitService = new FederateUnitServiceImpl();
	}
	
	public FederateUnit create(FederateUnit federateUnit) {
		return this.federateUnitService.create(federateUnit);
	}
	
	public List<FederateUnit> findAll() {
		return this.federateUnitService.findAll();
	}
	
	public FederateUnit findById(Long id) {
		return this.federateUnitService.findById(id);
	}
	
	public FederateUnit update(FederateUnit federateUnit) {
		return this.federateUnitService.update(federateUnit);
	}
	
	public FederateUnit delete(FederateUnit federateUnit) {
		return this.federateUnitService.delete(federateUnit);
	}
	

}
