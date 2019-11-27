package br.unifacisa.si2.api.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Serasa implements Serializable {

	private static final long serialVersionUID = -7799369695818057571L;
	
	@Id @GeneratedValue
	private String id;
	private long cpfDevedor;
	private String nomeDevedor;
	private String cnpjEmpresa;
	private String nomeEmpresa;
	private String motivo;
	
	public Serasa() {
	}

	public Serasa(String id, long cpfDevedor, String nomeDevedor, String cnpjEmpresa, String nomeEmpresa, String motivo) {
		this.id = id;
		this.cpfDevedor = cpfDevedor;
		this.nomeDevedor = nomeDevedor;
		this.cnpjEmpresa = cnpjEmpresa;
		this.nomeEmpresa = nomeEmpresa;
		this.motivo = motivo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public long getCpfDevedor() {
		return cpfDevedor;
	}

	public void setCpfDevedor(long cpfDevedor) {
		this.cpfDevedor = cpfDevedor;
	}

	public String getNomeDevedor() {
		return nomeDevedor;
	}

	public void setNomeDevedor(String nomeDevedor) {
		this.nomeDevedor = nomeDevedor;
	}

	public String getCnpjEmpresa() {
		return cnpjEmpresa;
	}

	public void setCnpjEmpresa(String cnpjEmpresa) {
		this.cnpjEmpresa = cnpjEmpresa;
	}

	public String getNomeEmpresa() {
		return nomeEmpresa;
	}

	public void setNomeEmpresa(String nomeEmpresa) {
		this.nomeEmpresa = nomeEmpresa;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}
	
}