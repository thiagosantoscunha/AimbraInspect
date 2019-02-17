package br.com.aimbra.inspection.business;

import java.util.List;

import br.com.aimbra.inspection.entities.District;
import br.com.aimbra.inspection.repositories.CityRepository;
import br.com.aimbra.inspection.repositories.CityRepositoryImpl;
import br.com.aimbra.inspection.repositories.DistrictRepository;
import br.com.aimbra.inspection.repositories.DistrictRepositoryImpl;

public class DistrictServiceImpl implements DistrictService {
	
	private DistrictRepository districtRepository;
	private CityRepository cityRepository;
	
	public DistrictServiceImpl() {
		this.districtRepository = new DistrictRepositoryImpl();
		this.cityRepository = new CityRepositoryImpl();
	}

	@Override
	public List<District> findAll() {
		try {
			List<District> districts = this.districtRepository.findAll();
			return districts == null ? null : districts;
		} catch (Exception ex) {
			throw ex;
		}
	}

	@Override
	public District findById(Long id) {
		try {
			District district = this.districtRepository.findById(id);
			return district == null ? null : district;
		} catch (Exception ex) {
			throw ex;
		}
	}

	@Override
	public District create(District district) {
		try {
			district.setCity(this.cityRepository.findByName(district.getCity()));
			district = this.districtRepository.create(district);
			return district == null ? null : district;
		} catch (Exception ex) {
			throw ex;			
		}
	}

	@Override
	public District update(District district) {
		try {
			district = this.districtRepository.update(district);
			return district == null ? null : district;
		} catch (Exception ex) {
			throw ex;
		}
	}

	@Override
	public District delete(District district) {
		try {
			district = this.districtRepository.delete(district);
			return district == null ? null : district;
		} catch (Exception ex) {
			throw ex;
		}
	}

	@Override
	public District findByName(District district) {
		try {
			district = this.districtRepository.findByName(district);
			return district == null ? null : district;
		} catch (Exception e) {
			throw e;
		}
	}

}
