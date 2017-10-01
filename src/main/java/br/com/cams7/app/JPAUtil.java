package br.com.cams7.app;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

	private final String PU = "app-pu";

	@Produces
	@ApplicationScoped
	public EntityManagerFactory getEMF() {
		return Persistence.createEntityManagerFactory(PU);
	}

	@Produces
	@RequestScoped
	public EntityManager getEM(EntityManagerFactory emf) {
		return emf.createEntityManager();
	}

	public void closeEM(@Disposes EntityManager em) {
		if (em.isOpen())
			em.close();
	}

}