package br.com.aimbra.inspection.business;

import java.util.List;

import br.com.aimbra.inspection.arguments.FederateUnitRequest;
import br.com.aimbra.inspection.arguments.FederateUnitResponse;

public interface FederateUnitService {
	List<FederateUnitResponse> findAll();
	FederateUnitResponse findById(Long id);
	FederateUnitResponse findByInitials(String initials);
	FederateUnitResponse create(FederateUnitRequest ufRequest);
	FederateUnitResponse update(FederateUnitRequest ufRequest);
	FederateUnitResponse delete(FederateUnitRequest ufRequest);
}
