package br.com.aimbra.inspection.controllers;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.aimbra.inspection.arguments.FederateUnitRequest;
import br.com.aimbra.inspection.arguments.FederateUnitResponse;
import br.com.aimbra.inspection.business.FederateUnitService;
import br.com.aimbra.inspection.business.FederateUnitServiceImpl;

public class FederateUnitController {
	
	private FederateUnitService federateUnitService;

	public FederateUnitController(EntityManager em) {
		this.federateUnitService = new FederateUnitServiceImpl(em);
	}
	
	public FederateUnitResponse create(FederateUnitRequest federateUnit) {
		return this.federateUnitService.create(federateUnit);
	}
	
	public List<FederateUnitResponse> findAll() {
		return this.federateUnitService.findAll();
	}
	
	public FederateUnitResponse findById(Long id) {
		return this.federateUnitService.findById(id);
	}
	
	public FederateUnitResponse update(FederateUnitRequest federateUnit) {
		return this.federateUnitService.update(federateUnit);
	}
	
	public FederateUnitResponse delete(FederateUnitRequest federateUnit) {
		return this.federateUnitService.delete(federateUnit);
	}
	
	public FederateUnitResponse findByInitials(String initials) {
		return this.federateUnitService.findByInitials(initials);
	}

}
