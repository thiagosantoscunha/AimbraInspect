package br.com.aimbra.inspection.business;

import br.com.aimbra.inspection.arguments.InspectionFileRequest;

public interface FileService {
	
	void create(InspectionFileRequest request);
	
}
