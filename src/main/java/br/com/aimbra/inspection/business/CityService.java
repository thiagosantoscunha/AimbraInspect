package br.com.aimbra.inspection.business;

import java.util.List;

import br.com.aimbra.inspection.entities.City;


public interface CityService {
	List<City> findAll();
	City findById(Long id);
	City create(City city);
	City update(City city);
	City delete(City city);
}
