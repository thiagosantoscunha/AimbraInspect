package br.com.aimbra.inspection.business;

import java.util.List;

import br.com.aimbra.inspection.entities.District;


public interface DistrictService {
	List<District> findAll();
	District findById(Long id);
	District create(District district);
	District update(District district);
	District delete(District district);
	District findByName(District district);
}
