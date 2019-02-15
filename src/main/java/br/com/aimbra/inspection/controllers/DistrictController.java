package br.com.aimbra.inspection.controllers;

import java.util.List;

import br.com.aimbra.inspection.business.DistrictService;
import br.com.aimbra.inspection.business.DistrictServiceImpl;
import br.com.aimbra.inspection.entities.District;

public class DistrictController {
	
	private DistrictService districtService;
	
	public DistrictController() {
		this.districtService = new DistrictServiceImpl();
	}
	
	public District create(District district) {
		return this.districtService.create(district);
	}
	
	public List<District> findAll() {
		return this.districtService.findAll();
	}
	
	public District findById(Long id) {
		return this.districtService.findById(id);
	}
	
	public District update(District district) {
		return this.districtService.update(district);
	}
	
	public District delete(District district) {
		return this.districtService.delete(district);
	}
	
}
