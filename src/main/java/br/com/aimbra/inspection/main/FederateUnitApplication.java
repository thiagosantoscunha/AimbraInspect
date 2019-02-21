package br.com.aimbra.inspection.main;

import javax.persistence.EntityManager;

import br.com.aimbra.inspection.arguments.FederateUnitRequest;
import br.com.aimbra.inspection.arguments.FederateUnitResponse;
import br.com.aimbra.inspection.connection.JPAUtil;
import br.com.aimbra.inspection.controllers.FederateUnitController;

public class FederateUnitApplication {

	public static void main(String[] args) {
		
		EntityManager em;
		em = JPAUtil.getEntityManager();

		FederateUnitRequest ufRequest = new FederateUnitRequest("Rio de Janeiro", "RJ", 5L);

		em.getTransaction().begin();
		FederateUnitController federateUnitController = new FederateUnitController(em);
		FederateUnitResponse ufResponse = federateUnitController.update(ufRequest);
		em.getTransaction().commit();
		em.close();
		System.out.println(ufResponse);
		
		
		System.exit(0);
		
	}

}
