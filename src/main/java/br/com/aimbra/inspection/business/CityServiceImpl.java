package br.com.aimbra.inspection.business;

import java.util.List;

import br.com.aimbra.inspection.entities.City;
import br.com.aimbra.inspection.repositories.CityRepository;
import br.com.aimbra.inspection.repositories.CityRepositoryImpl;

public class CityServiceImpl implements CityService {
	
	private CityRepository cityRepository;
	
	public CityServiceImpl() {
		this.cityRepository = new CityRepositoryImpl();
	}
	
	@Override
	public List<City> findAll() {
		try {
			List<City> cities = this.cityRepository.findAll();
			if (cities == null) return null;
			return cities;
		} catch (Exception ex) {
			throw ex;
		}
	}

	@Override
	public City findById(Long id) {
		try {
			City city = this.cityRepository.findById(id);
			if (city == null) return null;
			return city;
		} catch (Exception ex) {
			throw ex;
		}
	}

	@Override
	public City create(City city) {
		try {
			city = this.cityRepository.create(city);
			if (city == null) return null;
			return city;
		} catch (Exception ex) {
			throw ex;
		}
	}

	@Override
	public City update(City city) {
		try {
			city = this.cityRepository.update(city);
			if (city == null) return null;
			return city;
		} catch (Exception ex) {
			throw ex;
		}
	}

	@Override
	public City delete(City city) {
		try {
			city = this.cityRepository.delete(city);
			if (city == null) return null;
			return city;
		} catch (Exception ex) {
			throw ex;
		}
	}

}
