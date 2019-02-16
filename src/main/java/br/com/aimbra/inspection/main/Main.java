package br.com.aimbra.inspection.main;

import br.com.aimbra.inspection.controllers.CompanyInspectionController;

public class Main {
	
	public static void main(String[] args) {
		
		
		CompanyInspectionController companyInspectionController = new CompanyInspectionController();
		companyInspectionController.readFile();
		
		
		System.exit(0);
	}

}
