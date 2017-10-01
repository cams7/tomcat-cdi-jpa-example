/**
 * 
 */
package br.com.cams7.app.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.cams7.app.model.AppDaoImpl;
import br.com.cams7.app.model.ContatoDao;
import br.com.cams7.app.model.entity.Contato;

/**
 * @author César Magalhães
 *
 */
public class ContatoServiceImpl extends AppServiceImpl<ContatoDao, Contato, Long> implements ContatoService {

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.com.cams7.app.model.AppDao#salva(java.lang.Object)
	 */
	@Override
	public void salva(Contato contato) {
		Long contatoId = contato.getId();

		Contato c = null;
		if (contatoId != null)
			c = buscaPeloId(contatoId);
		else
			c = new Contato();

		c.setNome(contato.getNome());
		c.setTelefone(contato.getTelefone());

		@SuppressWarnings("unchecked")
		AppDaoImpl<Contato, Long> dao = (AppDaoImpl<Contato, Long>) getDao();
		EntityManager entityManager = dao.getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		super.salva(c);
		transaction.commit();

	}

}
