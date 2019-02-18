package br.com.aimbra.inspection.repositories;

import br.com.aimbra.inspection.entities.City;
import br.com.aimbra.inspection.entities.District;

public interface DistrictRepository extends BaseRepository<District> {
	
	District findByName(District district);
	District findByNameAndCity(District district, City city);
	public boolean exist(District district);
	boolean existOnCity(District district, City city);
}
