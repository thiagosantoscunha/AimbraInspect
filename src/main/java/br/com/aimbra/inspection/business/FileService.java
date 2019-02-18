package br.com.aimbra.inspection.business;

import java.util.List;

import br.com.aimbra.inspection.arguments.InspectionFileRequest;

public interface FileService {
	
	void create(List<InspectionFileRequest> request);
	
}
