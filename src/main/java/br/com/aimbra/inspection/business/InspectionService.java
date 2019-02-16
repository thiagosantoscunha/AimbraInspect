package br.com.aimbra.inspection.business;

import java.util.List;

import br.com.aimbra.inspection.entities.Inspection;

public interface InspectionService {
	List<Inspection> findAll();
	Inspection findById(Long id);
	Inspection create(Inspection inspection);
	Inspection update(Inspection inspection);
	Inspection delete(Inspection inspection);
}
