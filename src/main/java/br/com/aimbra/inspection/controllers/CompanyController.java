package br.com.aimbra.inspection.controllers;

import java.util.List;

import br.com.aimbra.inspection.business.CompanyService;
import br.com.aimbra.inspection.business.CompanyServiceImpl;
import br.com.aimbra.inspection.entities.Company;

public class CompanyController {
	
	private CompanyService companyService;
	
	public CompanyController() {
		companyService = new CompanyServiceImpl();
	}
	
	public List<Company> findAll() {
		return this.companyService.findAll();
	}
	
	public Company findById(Long id) {
		return this.companyService.findById(id);
	}
	
	public Company create(Company company) {
		return this.companyService.create(company);
	}
	
	public Company update(Company company) {
		return this.companyService.update(company);
	}
	
	public Company delete(Company company) {
		return this.companyService.delete(company);
	}
	
}
