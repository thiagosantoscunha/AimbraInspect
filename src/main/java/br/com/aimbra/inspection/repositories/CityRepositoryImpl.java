package br.com.aimbra.inspection.repositories;

import java.util.List;

import javax.persistence.Query;

import br.com.aimbra.inspection.entities.City;

public class CityRepositoryImpl extends BaseRepositoryImpl<City> implements CityRepository {

	public CityRepositoryImpl() {
		super(City.class);
	}

	
	
}
