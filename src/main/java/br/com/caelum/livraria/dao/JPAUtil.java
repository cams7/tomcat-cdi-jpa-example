package br.com.caelum.livraria.dao;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

	private final static EntityManagerFactory EMF;

	static {
		EMF = Persistence.createEntityManagerFactory("app-pu");
	}

	@Produces
	@RequestScoped
	public EntityManager getEntityManager() {
		return EMF.createEntityManager();
	}

	public void close(@Disposes EntityManager em) {
		em.close();
	}
}