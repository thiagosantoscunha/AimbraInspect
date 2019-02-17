package br.com.aimbra.inspection.repositories;

import br.com.aimbra.inspection.entities.FederateUnit;

public interface FederateUnitRepository extends BaseRepository<FederateUnit> {
	FederateUnit findByInitials(FederateUnit uf);
}
