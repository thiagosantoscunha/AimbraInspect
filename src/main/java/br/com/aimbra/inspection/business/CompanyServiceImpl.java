package br.com.aimbra.inspection.business;

import java.util.List;

import br.com.aimbra.inspection.entities.Company;
import br.com.aimbra.inspection.repositories.CityRepository;
import br.com.aimbra.inspection.repositories.CityRepositoryImpl;
import br.com.aimbra.inspection.repositories.CompanyRepository;
import br.com.aimbra.inspection.repositories.CompanyRepositoryImpl;
import br.com.aimbra.inspection.repositories.DistrictRepository;
import br.com.aimbra.inspection.repositories.DistrictRepositoryImpl;
import br.com.aimbra.inspection.repositories.FederateUnitRepository;
import br.com.aimbra.inspection.repositories.FederateUnitRepositoryImpl;

public class CompanyServiceImpl implements CompanyService {
	
	private CompanyRepository companyRepository;
	private FederateUnitRepository federateUnitRepository;
	private CityRepository cityRepository;
	private DistrictRepository districtRepository;
	
	public CompanyServiceImpl() {
		companyRepository = new CompanyRepositoryImpl();
		federateUnitRepository = new FederateUnitRepositoryImpl();
		cityRepository = new CityRepositoryImpl();
		districtRepository = new DistrictRepositoryImpl();
	}

	@Override
	public List<Company> findAll() {
		try {
			List<Company> companies = this.companyRepository.findAll();
			return companies;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public Company findById(Long id) {
		try {
			Company company = this.companyRepository.findById(id);
			return company;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public Company create(Company company) {
		try {
			
			company.setFederateUnit(
					federateUnitRepository.findByInitials(company.getFederateUnit())
					);
			System.out.println(company.getFederateUnit());			
			
			company.setCity(
					cityRepository.findByName(company.getCity())
					);
			System.out.println(company.getCity());
			
			company.setDistrict(
					districtRepository.findByName(company.getDistrict())
					);
			System.out.println(company.getDistrict());
			
			company = this.companyRepository.create(company);
			
			return company == null ? null : company;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public Company update(Company company) {
		try {
			company = this.companyRepository.update(company);
			return company == null ? null : company;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public Company delete(Company company) {
		try {
			company = this.companyRepository.delete(company);
			return company == null ? null : company;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public Company findByCnpj(Company company) {
		try {
			company = this.companyRepository.findByCnpj(company);
			return company == null ? null : company;
		} catch (Exception e) {
			throw e;
		}
	}

}
