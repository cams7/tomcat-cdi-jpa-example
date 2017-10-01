/**
 * 
 */
package br.com.cams7.app.service;

import java.io.Serializable;

import br.com.cams7.app.model.AppDao;
import br.com.cams7.app.model.entity.AbstractEntity;

/**
 * @author César Magalhães
 *
 */
public interface AppService<E extends AbstractEntity<PK>, PK extends Serializable> extends AppDao<E, PK> {

}
