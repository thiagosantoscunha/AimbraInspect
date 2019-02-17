package br.com.aimbra.inspection.repositories;

import javax.persistence.Query;

import br.com.aimbra.inspection.entities.Company;

public class CompanyRepositoryImpl extends BaseRepositoryImpl<Company> implements CompanyRepository {

	public CompanyRepositoryImpl() {
		super(Company.class);
	}

	@Override
	public Company findByCnpj(Company company) {
		try {
			Query query = em.createQuery("SELECT c FROM Company c WHERE c.cnpj=:pCompanyCnpj");
			query.setParameter("pCompanyCnpj", company.getCnpj());
			return (Company) query.getSingleResult();				
		} catch (Exception e) {
			throw e;
		}
	}

}
