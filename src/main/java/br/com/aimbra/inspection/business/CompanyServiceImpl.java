package br.com.aimbra.inspection.business;

import java.util.List;

import br.com.aimbra.inspection.entities.Company;
import br.com.aimbra.inspection.repositories.CompanyRepository;
import br.com.aimbra.inspection.repositories.CompanyRepositoryImpl;

public class CompanyServiceImpl implements CompanyService {
	
	private CompanyRepository companyRepository;
	
	public CompanyServiceImpl() {
		this.companyRepository = new CompanyRepositoryImpl();
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
			company = this.companyRepository.create(company);
			return company;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public Company update(Company company) {
		try {
			company = this.companyRepository.update(company);
			return company;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public Company delete(Company company) {
		try {
			company = this.companyRepository.delete(company);
			return company;
		} catch (Exception e) {
			throw e;
		}
	}

}
