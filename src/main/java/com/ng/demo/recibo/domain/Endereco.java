package com.ng.demo.recibo.domain;

import java.io.Serializable;
import java.util.Objects;


public class Endereco implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String rua;
	private String cidade;
	private String estado;
	private String cep;
	
	public Endereco() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Endereco(String rua, String cidade, String estado, String cep) {
		super();
		this.rua = rua;
		this.cidade = cidade;
		this.estado = estado;
		this.cep = cep;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cep, cidade, estado, rua);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Endereco other = (Endereco) obj;
		return Objects.equals(cep, other.cep) && Objects.equals(cidade, other.cidade)
				&& Objects.equals(estado, other.estado) && Objects.equals(rua, other.rua);
	}

	@Override
	public String toString() {
		return "Endereco [rua=" + rua + ", cidade=" + cidade + ", estado=" + estado + ", cep=" + cep + "]";
	}
	
	
	
	
}
