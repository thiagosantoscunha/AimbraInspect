package br.com.aimbra.inspection.business;

import java.util.List;

import br.com.aimbra.inspection.entities.Inspection;
import br.com.aimbra.inspection.repositories.CityRepository;
import br.com.aimbra.inspection.repositories.CityRepositoryImpl;
import br.com.aimbra.inspection.repositories.CompanyRepository;
import br.com.aimbra.inspection.repositories.CompanyRepositoryImpl;
import br.com.aimbra.inspection.repositories.DistrictRepository;
import br.com.aimbra.inspection.repositories.DistrictRepositoryImpl;
import br.com.aimbra.inspection.repositories.FederateUnitRepository;
import br.com.aimbra.inspection.repositories.FederateUnitRepositoryImpl;
import br.com.aimbra.inspection.repositories.InspectionRepository;
import br.com.aimbra.inspection.repositories.InspectionRepositoryImpl;

public class InspectionServiceImpl implements InspectionService {

	private InspectionRepository inspectionRepository;
	private FederateUnitRepository federateRepository;
	private CityRepository cityRepository;
	private DistrictRepository districtRepository;
	private CompanyRepository companyRepository;
	
	public InspectionServiceImpl() {
		inspectionRepository = new InspectionRepositoryImpl();
		federateRepository = new FederateUnitRepositoryImpl();
		cityRepository = new CityRepositoryImpl();
		districtRepository = new DistrictRepositoryImpl();
		companyRepository = new CompanyRepositoryImpl();
	}

	@Override
	public List<Inspection> findAll() {
		try {
			List<Inspection> inspections = this.inspectionRepository.findAll();
			return inspections == null ? null : inspections;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public Inspection findById(Long id) {
		try {
			Inspection inspect = this.inspectionRepository.findById(id);
			return inspect == null ? null : inspect;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public Inspection create(Inspection inspection) {
		try {
			
			inspection.setFederateUnit(
					federateRepository.findByInitials(inspection.getFederateUnit())
					);
			
			inspection.setCity(
					cityRepository.findByName(inspection.getCity())
					);
			
			inspection.setDistrict(
					districtRepository.findByName(inspection.getDistrict())
					);
			
			inspection.setCompany(
					companyRepository.findByCnpj(inspection.getCompany())
					);
			
			inspection = this.inspectionRepository.create(inspection);
			return inspection == null ? null : inspection;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public Inspection update(Inspection inspection) {
		try {
			Inspection inspect = this.inspectionRepository.update(inspection);
			return inspect == null ? null : inspect;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public Inspection delete(Inspection inspection) {
		try {
			Inspection inspect = this.inspectionRepository.delete(inspection);
			return inspect == null ? null : inspect;
		} catch (Exception e) {
			throw e;
		}
	}
	
}
