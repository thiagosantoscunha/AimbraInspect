package br.com.aimbra.inspection.repositories;

import br.com.aimbra.inspection.entities.City;
import br.com.aimbra.inspection.entities.FederateUnit;

public interface CityRepository extends BaseRepository<City> {
	City findByName(String name);
	public boolean exist(String name);
	boolean existOnFederalUnit(String name, FederateUnit uf);
}
