package br.com.cams7.app.model;

import java.io.Serializable;

import br.com.cams7.app.model.entity.AbstractEntity;

public interface AppDao<E extends AbstractEntity<PK>, PK extends Serializable> {
	/**
	 * Salva ou atualiza
	 * 
	 * @param entidade
	 *            Entidade
	 */
	void salva(E entidade);

	/**
	 * Busca entidade pelo ID
	 * 
	 * @param id
	 *            ID da entidade
	 * @return Entidade
	 */
	E buscaPeloId(PK id);

}
