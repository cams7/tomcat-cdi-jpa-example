/**
 * 
 */
package br.com.cams7.app.service;

import java.io.Serializable;

import javax.inject.Inject;

import br.com.cams7.app.model.AppDao;
import br.com.cams7.app.model.entity.AbstractEntity;

/**
 * @author César Magalhães
 *
 */
public abstract class AppServiceImpl<D extends AppDao<E, PK>, E extends AbstractEntity<PK>, PK extends Serializable>
		implements AppService<E, PK> {

	@Inject
	private D dao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.cams7.app.model.AppDao#salva(java.lang.Object)
	 */
	@Override
	public void salva(E entidade) {
		getDao().salva(entidade);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.cams7.app.model.AppDao#buscaPeloId(java.lang.Long)
	 */
	@Override
	public E buscaPeloId(PK id) {
		return getDao().buscaPeloId(id);
	}

	/**
	 * @return Data Acess Object
	 */
	protected D getDao() {
		return dao;
	}

}
