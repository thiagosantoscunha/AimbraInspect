package br.com.aimbra.inspection.business;

import java.util.List;

import br.com.aimbra.inspection.entities.District;
import br.com.aimbra.inspection.repositories.DistrictRepository;
import br.com.aimbra.inspection.repositories.DistrictRepositoryImpl;

public class DistrictServiceImpl implements DistrictService {
	
	private DistrictRepository districtRepository;
	
	
	public DistrictServiceImpl() {
		this.districtRepository = new DistrictRepositoryImpl();
	}

	@Override
	public List<District> findAll() {
		try {
			List<District> districts = this.districtRepository.findAll();
			if (districts == null) return null;
			return districts;
		} catch (Exception ex) {
			throw ex;
		}
	}

	@Override
	public District findById(Long id) {
		try {
			District district = this.districtRepository.findById(id);
			if (district == null) return null;
			return district;
		} catch (Exception ex) {
			throw ex;
		}
	}

	@Override
	public District create(District district) {
		try {
			district = this.districtRepository.create(district);
			if (district == null) return null;
			return district;
		} catch (Exception ex) {
			throw ex;			
		}
	}

	@Override
	public District update(District district) {
		try {
			district = this.districtRepository.update(district);
			if (district == null) return null;
			return district;
		} catch (Exception ex) {
			throw ex;
		}
	}

	@Override
	public District delete(District district) {
		try {
			district = this.districtRepository.delete(district);
			if (district == null) return null;
			return district;
		} catch (Exception ex) {
			throw ex;
		}
	}

}
