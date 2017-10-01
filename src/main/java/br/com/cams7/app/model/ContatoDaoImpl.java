/**
 * 
 */
package br.com.cams7.app.model;

import br.com.cams7.app.model.entity.Contato;

/**
 * @author César Magalhães
 *
 */
public class ContatoDaoImpl extends AppDaoImpl<Contato, Long> implements ContatoDao {

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.cams7.app.model.AppDaoImpl#getType()
	 */
	@Override
	protected Class<Contato> getEntityType() {
		return Contato.class;
	}

}
