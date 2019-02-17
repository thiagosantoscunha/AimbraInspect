package br.com.aimbra.inspection.business;

import java.lang.reflect.Type;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

import br.com.aimbra.inspection.arguments.CityRequest;
import br.com.aimbra.inspection.arguments.CityResponse;
import br.com.aimbra.inspection.entities.City;
import br.com.aimbra.inspection.entities.FederateUnit;
import br.com.aimbra.inspection.repositories.CityRepository;
import br.com.aimbra.inspection.repositories.CityRepositoryImpl;
import br.com.aimbra.inspection.repositories.FederateUnitRepository;
import br.com.aimbra.inspection.repositories.FederateUnitRepositoryImpl;

public class CityServiceImpl implements CityService {
	
	private CityRepository cityRepository;
	private FederateUnitRepository federateUnitRepository;
	private ModelMapper modelMapper;
	
	public CityServiceImpl() {
		this.cityRepository = new CityRepositoryImpl();
		this.federateUnitRepository = new FederateUnitRepositoryImpl();
		this.modelMapper = new ModelMapper();
	}
	
	@Override
	public List<City> findAll() {
		try {
			List<City> cities = this.cityRepository.findAll();
			return cities == null ? null : cities;
		} catch (Exception ex) {
			throw ex;
		}
	}

	@Override
	public City findById(Long id) {
		try {
			City city = this.cityRepository.findById(id);
			return city == null ? null : city;
		} catch (Exception ex) {
			throw ex;
		}
	}

	@Override
	public City create(City city) {
		try {
			FederateUnit uf = this.federateUnitRepository.findByInitials(city.getFederationUnit());
			city.setFederationUnit(uf);
			city = this.cityRepository.create(city);
			return city == null ? null : city;
		} catch (Exception ex) {
			throw ex;
		}
	}

	@Override
	public City update(City city) {
		try {
			city = this.cityRepository.update(city);
			return city == null ? null : city;
		} catch (Exception ex) {
			throw ex;
		}
	}

	@Override
	public City delete(City city) {
		try {
			city = this.cityRepository.delete(city);
			return city == null ? null : city;
		} catch (Exception ex) {
			throw ex;
		}
	}

	@Override
	public City findByName(City city) {
		try {
			city = this.cityRepository.findByName(city);
			return city == null ? null : city;
		} catch (Exception e) {
			throw e;
		}
	}

}
