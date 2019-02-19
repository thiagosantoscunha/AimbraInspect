package br.com.aimbra.inspection.repositories;

import br.com.aimbra.inspection.entities.Company;

public interface CompanyRepository extends BaseRepository<Company> {
	
	Company findByCnpj(String cnpj);
	public boolean exist(Company company);

}
