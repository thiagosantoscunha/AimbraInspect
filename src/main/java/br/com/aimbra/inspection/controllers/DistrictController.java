package br.com.aimbra.inspection.controllers;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.aimbra.inspection.business.DistrictService;
import br.com.aimbra.inspection.business.DistrictServiceImpl;
import br.com.aimbra.inspection.entities.District;

public class DistrictController {
	
	private DistrictService districtService;
	
	public DistrictController(EntityManager em) {
		this.districtService = new DistrictServiceImpl(em);
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
	
	public District findByName(District district) {
		return this.districtService.findByName(district);
	}
	
}
