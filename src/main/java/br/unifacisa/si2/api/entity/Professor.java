package br.unifacisa.si2.api.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Professor implements Serializable {

	private static final long serialVersionUID = -7799369695818057571L;
	
	@Id @GeneratedValue
	private String id;
	private String nome;
	private long cpf;
	private String area;
	
	public Professor() {
	}

	public Professor(String id, String nome, long cpf, String area) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.area = area;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public long getCpf() {
		return cpf;
	}

	public void setCpf(long cpf) {
		this.cpf = cpf;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

}
