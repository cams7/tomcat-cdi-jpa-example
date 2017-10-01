/**
 * 
 */
package br.com.cams7.app.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Entidade da referente aos entereços do contato
 * 
 * @author César Magalhães
 *
 */
@Entity
@SuppressWarnings("serial")
public class Endereco extends AbstractEntity<Long> {

	/**
	 * Id do endereço
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "endereco_id")
	private Long id;

	/**
	 * Logradouro
	 */
	private String rua;

	/**
	 * Número da residencia
	 */
	private int numero;

	/**
	 * Complemento ao endereço
	 */
	private String complemento;

	/**
	 * Contato ao qual pertence o endereço
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "contato_id", referencedColumnName = "contato_id")
	private Contato contato;

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}
}
