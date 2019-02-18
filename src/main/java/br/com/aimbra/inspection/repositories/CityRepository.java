package br.com.aimbra.inspection.repositories;

import br.com.aimbra.inspection.entities.City;
import br.com.aimbra.inspection.entities.FederateUnit;

public interface CityRepository extends BaseRepository<City> {
	City findByName(City city);
	public boolean exist(City city);
	boolean existOnFederalUnit(City city, FederateUnit uf);
}
