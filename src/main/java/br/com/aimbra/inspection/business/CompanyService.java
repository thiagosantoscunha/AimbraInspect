package br.com.aimbra.inspection.business;

import java.util.List;

import br.com.aimbra.inspection.entities.Company;

public interface CompanyService {
	List<Company> findAll();
	Company findById(Long id);
	Company findByCnpj(Company company);
	Company create(Company company);
	Company update(Company company);
	Company delete(Company company);
}
