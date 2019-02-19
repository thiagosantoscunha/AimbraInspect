package br.com.aimbra.inspection.repositories;

import br.com.aimbra.inspection.entities.City;
import br.com.aimbra.inspection.entities.District;

public interface DistrictRepository extends BaseRepository<District> {
	
	District findByName(String name);
	District findByNameOnCity(String name, City city);
	boolean exist(String name);
	boolean existOnCity(String name, City city);
}
