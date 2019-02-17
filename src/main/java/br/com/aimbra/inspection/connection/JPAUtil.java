package br.com.aimbra.inspection.connection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres-docker");

	public static EntityManager getEntityManager() {
		return emf.createEntityManager();
	}

}