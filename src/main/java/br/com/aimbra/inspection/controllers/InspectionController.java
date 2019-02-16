package br.com.aimbra.inspection.controllers;

import java.util.List;

import br.com.aimbra.inspection.business.InspectionService;
import br.com.aimbra.inspection.business.InspectionServiceImpl;
import br.com.aimbra.inspection.entities.Inspection;

public class InspectionController {

	private InspectionService inspectionService;

	public InspectionController() {
		this.inspectionService = new InspectionServiceImpl();
	}
	
	public List<Inspection> findAll() {
		return this.inspectionService.findAll();
	}
	
	public Inspection findById(Long id) {
		return this.inspectionService.findById(id);
	}
	
	public Inspection create(Inspection inspection) {
		return this.inspectionService.create(inspection);
	}
	
	public Inspection update(Inspection inspection) {
		return this.inspectionService.update(inspection);
	}
	
	public Inspection delete(Inspection inspection) {
		return this.inspectionService.delete(inspection);
	}
	
}
