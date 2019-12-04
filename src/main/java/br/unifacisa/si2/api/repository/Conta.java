package com.danielabella.rest.exemplo3.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.danielabella.rest.exemplo3.enums.TipoContaEnum;

@Entity
public class Conta implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int agencia;
	@Id
	private int conta;
	private String titular;
	private long cpf;
	private double saldo;
	private TipoContaEnum tipoConta;
	
	public Conta() {
	}

	public int getAgencia() {
		return agencia;
	}

	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}

	public int getConta() {
		return conta;
	}

	public void setConta(int conta) {
		this.conta = conta;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public long getCpf() {
		return cpf;
	}

	public void setCpf(long cpf) {
		this.cpf = cpf;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public TipoContaEnum getTipoConta() {
		return tipoConta;
	}

	public void setTipoConta(TipoContaEnum tipoConta) {
		this.tipoConta = tipoConta;
	}

}
