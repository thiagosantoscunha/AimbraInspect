package br.com.aimbra.inspection.business;

import java.lang.reflect.Type;
import java.util.List;

import javax.persistence.EntityManager;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

import br.com.aimbra.inspection.arguments.FederateUnitRequest;
import br.com.aimbra.inspection.arguments.FederateUnitResponse;
import br.com.aimbra.inspection.entities.FederateUnit;
import br.com.aimbra.inspection.repositories.FederateUnitRepository;
import br.com.aimbra.inspection.repositories.FederateUnitRepositoryImpl;
import br.com.aimbra.inspection.utils.FederateUnitSelection;

public class FederateUnitServiceImpl implements FederateUnitService {

	private FederateUnitRepository federateUnitRepository;
	private ModelMapper modelMapper;
	
	public FederateUnitServiceImpl(EntityManager em) {
		this.federateUnitRepository = new FederateUnitRepositoryImpl(em);
		this.modelMapper = new ModelMapper();
	}

	@Override
	public List<FederateUnitResponse> findAll() {
		try {
			List<FederateUnit> ufs = federateUnitRepository.findAll();
			if (ufs == null) return null;
			
			Type listType = new TypeToken<List<FederateUnitResponse>>() {}.getType();
			List<FederateUnitResponse> ufResponses = modelMapper.map(ufs, listType);
			
			return ufResponses;
		} catch (Exception ex) {
			throw ex;
		}
	}

	@Override
	public FederateUnitResponse findById(Long id) {
		try {
			if (id == null) return null;
			FederateUnit uf = federateUnitRepository.findById(id);
			if (uf == null) return null;
			return modelMapper.map(uf, FederateUnitResponse.class);
		} catch (Exception ex) {
			throw ex;
		}
	}

	@Override
	public FederateUnitResponse create(FederateUnitRequest federateUnitRequest) {
		try {
			
			if (federateUnitRequest == null ||
				federateUnitRequest.getName() == null   ||
				federateUnitRequest.getName().isEmpty()
				) return null;
			
			FederateUnit uf = modelMapper.map(federateUnitRequest, FederateUnit.class);
			uf = FederateUnitSelection.getFederateUnitInstance(uf.getName());
			uf = this.federateUnitRepository.create(uf);
			return modelMapper.map(uf, FederateUnitResponse.class);
		} catch (Exception ex) {
			throw ex;
		}
	}

	@Override
	public FederateUnitResponse update(FederateUnitRequest federateUnitRequest) {
		try {
			FederateUnit uf = modelMapper.map(federateUnitRequest, FederateUnit.class);
			
			uf = this.federateUnitRepository.update(uf);
			
			if (uf == null) return null;
			
			return modelMapper.map(uf, FederateUnitResponse.class);
		} catch (Exception ex) {
			throw ex;
		}
	}

	@Override
	public FederateUnitResponse delete(FederateUnitRequest federateUnitRequest) {
		try {
			FederateUnit uf = modelMapper.map(federateUnitRequest, FederateUnit.class);	
			uf = this.federateUnitRepository.delete(uf);
			if (uf == null) return null;
			return modelMapper.map(uf, FederateUnitResponse.class);
		} catch (Exception ex) {
			throw ex;
		}
	}

	@Override
	public FederateUnitResponse findByInitials(String initials) {
		try {
			FederateUnit uf = this.federateUnitRepository.findByInitials(initials);
			if (uf == null) return null;
			return modelMapper.map(uf, FederateUnitResponse.class);
		} catch (Exception ex) {
			throw ex;
		}
	}
	
}
