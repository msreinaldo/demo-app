package com.ng.demo.recibo.domain;

import java.io.Serializable;
import java.util.Objects;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "recibo")
@XmlAccessorType(XmlAccessType.FIELD)
public class Recibo implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String id;
	private Empresa empresa;
	private Cliente cliente;
	private Double totalRecebido;
	
	public Recibo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Recibo(String iD, Empresa empresa, Cliente cliente, Double totalRecebido) {
		super();
		id = iD;
		this.empresa = empresa;
		this.cliente = cliente;
		this.totalRecebido = totalRecebido;
	}
	public String getID() {
		return id;
	}
	public void setID(String iD) {
		id = iD;
	}
	public Empresa getEmpresa() {
		return empresa;
	}
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Double getTotalRecebido() {
		return totalRecebido;
	}
	public void setTotalRecebido(Double totalRecebido) {
		this.totalRecebido = totalRecebido;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id, cliente, empresa, totalRecebido);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Recibo other = (Recibo) obj;
		return Objects.equals(id, other.id) && Objects.equals(cliente, other.cliente)
				&& Objects.equals(empresa, other.empresa) && Objects.equals(totalRecebido, other.totalRecebido);
	}
	@Override
	public String toString() {
		return "Recibo [ID=" + id + ", empresa=" + empresa + ", cliente=" + cliente + ", totalRecebido=" + totalRecebido
				+ "]";
	}
	
	

}
