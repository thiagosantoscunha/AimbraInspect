package br.com.aimbra.inspection.business;

import java.util.List;

import br.com.aimbra.inspection.entities.Inspection;
import br.com.aimbra.inspection.repositories.InspectionRepository;
import br.com.aimbra.inspection.repositories.InspectionRepositoryImpl;

public class InspectionServiceImpl implements InspectionService {

	private InspectionRepository inspectionRepository;
	
	public InspectionServiceImpl() {
		inspectionRepository = new InspectionRepositoryImpl();
	}

	@Override
	public List<Inspection> findAll() {
		try {
			List<Inspection> inspections = this.inspectionRepository.findAll();
			if (inspections == null) return null;
			return inspections;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public Inspection findById(Long id) {
		try {
			Inspection inspect = this.inspectionRepository.findById(id);
			if (inspect == null) return null;
			return inspect;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public Inspection create(Inspection inspection) {
		try {
			Inspection inspect = this.inspectionRepository.create(inspection);
			if (inspect == null) return null;
			return inspect;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public Inspection update(Inspection inspection) {
		try {
			Inspection inspect = this.inspectionRepository.update(inspection);
			if (inspect == null) return null;
			return inspect;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public Inspection delete(Inspection inspection) {
		try {
			Inspection inspect = this.inspectionRepository.delete(inspection);
			if (inspect == null) return null;
			return inspect;
		} catch (Exception e) {
			throw e;
		}
	}
	
}
