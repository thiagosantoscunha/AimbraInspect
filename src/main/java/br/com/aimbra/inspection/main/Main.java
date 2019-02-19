package br.com.aimbra.inspection.main;

import javax.persistence.EntityManager;

import br.com.aimbra.inspection.connection.JPAUtil;
import br.com.aimbra.inspection.controllers.CompanyInspectionController;

public class Main {
	
	public static void main(String[] args) {
		
		EntityManager em = JPAUtil.getEntityManager();
		
		CompanyInspectionController companyInspectionController = new CompanyInspectionController();
		companyInspectionController.readFile();
		
		System.exit(0);
	}

}
