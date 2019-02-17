package br.com.aimbra.inspection.repositories;

import br.com.aimbra.inspection.entities.Company;

public class CompanyRepositoryImpl extends BaseRepositoryImpl<Company> implements CompanyRepository {

	public CompanyRepositoryImpl() {
		super(Company.class);
	}

}
