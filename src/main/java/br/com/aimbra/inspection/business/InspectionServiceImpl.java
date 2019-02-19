package br.com.aimbra.inspection.business;

import java.util.List;

import javax.persistence.EntityManager;

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
	
	public InspectionServiceImpl(EntityManager em) {
		inspectionRepository = new InspectionRepositoryImpl(em);
		federateRepository = new FederateUnitRepositoryImpl(em);
		cityRepository = new CityRepositoryImpl(em);
		districtRepository = new DistrictRepositoryImpl(em);
		companyRepository = new CompanyRepositoryImpl(em);
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
					federateRepository.findByInitials(inspection.getFederateUnit().getInitials())
					);
			
			inspection.setCity(
					cityRepository.findByName(inspection.getCity().getName())
					);
			
			inspection.setDistrict(
					districtRepository.findByName(inspection.getDistrict().getName())
					);
			
			inspection.setCompany(
					companyRepository.findByCnpj(inspection.getCompany().getCnpj())
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
