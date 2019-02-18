package br.com.aimbra.inspection.repositories;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import br.com.aimbra.inspection.entities.Company;

public class CompanyRepositoryImpl extends BaseRepositoryImpl<Company> implements CompanyRepository {

	public CompanyRepositoryImpl() {
		super(Company.class);
	}

	@Override
	public Company findByCnpj(Company company) {
		try {
			em.getTransaction().begin();
			Query query = em.createQuery("SELECT c FROM Company c WHERE c.cnpj=:pCompanyCnpj");
			query.setParameter("pCompanyCnpj", company.getCnpj());
			company = (Company) query.getSingleResult();
			em.getTransaction().commit();
			return company;
		} catch (Exception e) {
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
		return null;
	}
	
	@Override
	public boolean exist(Company company) {
		em.getTransaction().begin();
		TypedQuery<Company> query = em.createQuery("select c from Company c where c.name = :pName or c.cnpj = :pCnpj", Company.class);
		query.setParameter("pName", company.getName());
		query.setParameter("pCnpj", company.getCnpj());
		try {
			@SuppressWarnings("unused")
			Company c = query.getSingleResult();
			em.getTransaction().commit();
			return true;
		} catch (NoResultException ex) {
			return false;
		}
	}
	
}
