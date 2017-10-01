/**
 * 
 */
package br.com.cams7.app.model;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.cams7.app.model.entity.AbstractEntity;

/**
 * @author César Magalhães
 *
 */
public abstract class AppDaoImpl<E extends AbstractEntity<PK>, PK extends Serializable> implements AppDao<E, PK> {

	@Inject
	private EntityManager entityManager;

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.cams7.app.model.AppDao#salva(java.lang.Object)
	 */
	@Override
	public void salva(E entidade) {
		getEntityManager().persist(entidade);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.cams7.app.model.AppDao#buscaPeloId(java.lang.Long)
	 */
	@Override
	public E buscaPeloId(PK id) {
		E entidade = getEntityManager().find(getEntityType(), id);
		return entidade;
	}

	/**
	 * @return Gerenciador de entidade
	 */
	public EntityManager getEntityManager() {
		return entityManager;
	}

	protected abstract Class<E> getEntityType();

}
