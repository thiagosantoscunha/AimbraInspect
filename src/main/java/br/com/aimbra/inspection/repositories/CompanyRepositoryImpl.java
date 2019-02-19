package br.com.aimbra.inspection.repositories;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.aimbra.inspection.entities.Company;

public class CompanyRepositoryImpl extends BaseRepositoryImpl<Company> implements CompanyRepository {

	public CompanyRepositoryImpl(EntityManager em) {
		super(Company.class, em);
	}

	@Override
	public Company findByCnpj(String cnpj) {
		try {
			TypedQuery<Company> query = em.createQuery("SELECT c FROM Company c WHERE c.cnpj=:pCompanyCnpj", Company.class);
			query.setParameter("pCompanyCnpj", cnpj);
			return query.getSingleResult();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	@Override
	public boolean exist(Company company) {
		TypedQuery<Company> query = em.createQuery("SELECT c FROM Company c WHERE c.name=:pName or c.cnpj=:pCnpj", Company.class);
		query.setParameter("pName", company.getName());
		query.setParameter("pCnpj", company.getCnpj());
		try {
			return query.getSingleResult() != null;
		} catch (NoResultException e) {			
			System.out.println(e.getMessage());
			return false;
		} 
	}
	
}
