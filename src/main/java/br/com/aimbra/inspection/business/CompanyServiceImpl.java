package br.com.aimbra.inspection.business;

import java.util.List;

import javax.persistence.EntityManager;

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
	
	public CompanyServiceImpl(EntityManager em) {
		companyRepository = new CompanyRepositoryImpl(em);
		federateUnitRepository = new FederateUnitRepositoryImpl(em);
		cityRepository = new CityRepositoryImpl(em);
		districtRepository = new DistrictRepositoryImpl(em);
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
					federateUnitRepository.findByInitials(company.getFederateUnit().getInitials())
					);
			System.out.println(company.getFederateUnit());			
			
			company.setCity(
					cityRepository.findByName(company.getCity().getName())
					);
			System.out.println(company.getCity());
			
			company.setDistrict(
					districtRepository.findByName(company.getDistrict().getName())
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
			company = this.companyRepository.findByCnpj(company.getCnpj());
			return company == null ? null : company;
		} catch (Exception e) {
			throw e;
		}
	}

}
