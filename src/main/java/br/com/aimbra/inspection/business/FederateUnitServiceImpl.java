package br.com.aimbra.inspection.business;

import java.util.List;

import br.com.aimbra.inspection.entities.FederateUnit;
import br.com.aimbra.inspection.repositories.FederateUnitRepository;
import br.com.aimbra.inspection.repositories.FederateUnitRepositoryImpl;

public class FederateUnitServiceImpl implements FederateUnitService {

	private FederateUnitRepository federateUnitRepository;
	
	
	public FederateUnitServiceImpl() {
		this.federateUnitRepository = new FederateUnitRepositoryImpl();
	}

	@Override
	public List<FederateUnit> findAll() {
		try {
			List<FederateUnit> ufs =  this.federateUnitRepository.findAll();
			if (ufs == null) return null;
			return ufs;
		} catch (Exception ex) {
			throw ex;
		}
	}

	@Override
	public FederateUnit findById(Long id) {
		try {
			FederateUnit uf =  this.federateUnitRepository.findById(id);
			if (uf == null) return null;
			return uf;
		} catch (Exception ex) {
			throw ex;
		}
	}

	@Override
	public FederateUnit create(FederateUnit federateUnit) {
		try {
			FederateUnit uf =  this.federateUnitRepository.create(federateUnit);
			if (uf == null) return null;
			return uf;
		} catch (Exception ex) {
			throw ex;
		}
	}

	@Override
	public FederateUnit update(FederateUnit federateUnit) {
		try {
			FederateUnit uf =  this.federateUnitRepository.update(federateUnit);
			if (uf == null) return null;
			return uf;
		} catch (Exception ex) {
			throw ex;
		}
	}

	@Override
	public FederateUnit delete(FederateUnit federateUnit) {
		try {
			FederateUnit uf =  this.federateUnitRepository.delete(federateUnit);
			if (uf == null) return null;
			return uf;
		} catch (Exception ex) {
			throw ex;
		}
	}

	@Override
	public FederateUnit findByInitials(FederateUnit uf) {
		try {
			uf = this.federateUnitRepository.findByInitials(uf);
			if (uf == null) return null;
			return uf;
		} catch (Exception ex) {
			throw ex;
		}
	}
	
}
