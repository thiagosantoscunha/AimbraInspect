package br.com.aimbra.inspection.main;

import javax.persistence.EntityManager;

import br.com.aimbra.inspection.connection.JPAUtil;
import br.com.aimbra.inspection.entities.User;

public class Main {
	
	public static void main(String[] args) {
		System.out.println("Hello World, Java!");
		
		User u = new User();
		u.setUsername("codenome");
		
		
		EntityManager em = JPAUtil.getEntityManager();
		try {
			em.getTransaction().begin();
			
			em.persist(u);
			
			em.getTransaction().commit();
		} catch(Exception ex) {
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
		System.exit(0);
	}

}
