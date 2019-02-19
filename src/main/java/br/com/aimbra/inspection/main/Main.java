package br.com.aimbra.inspection.main;

import javax.persistence.EntityManager;

import br.com.aimbra.inspection.connection.JPAUtil;
import br.com.aimbra.inspection.controllers.CompanyInspectionController;

public class Main {

	public static void main(String[] args) {

		EntityManager em = JPAUtil.getEntityManager();

		CompanyInspectionController companyInspectionController = new CompanyInspectionController(em);
		companyInspectionController.readFile();

		System.out.println("\n\n\n\tPrograma finalizado");
		System.exit(0);
	}

}
