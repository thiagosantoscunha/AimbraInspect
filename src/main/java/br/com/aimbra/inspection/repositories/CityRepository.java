package br.com.aimbra.inspection.repositories;

import br.com.aimbra.inspection.entities.City;

public interface CityRepository extends BaseRepository<City> {
	City findByName(City city);
}
