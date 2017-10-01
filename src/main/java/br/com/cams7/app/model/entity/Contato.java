/**
 * 
 */
package br.com.cams7.app.model.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * Entidade da referente aos contatos
 * 
 * @author César Magalhães
 *
 */
@Entity
@SuppressWarnings("serial")
public class Contato extends AbstractEntity<Long> {

	/**
	 * Id do contato
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "contato_id")
	private Long id;

	/**
	 * Nome do contato
	 */
	private String nome;

	/**
	 * Telefone do contato
	 */
	private String telefone;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "contato")
	private List<Endereco> enderecos;

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}
}