package com.gwtransportes.CRUDTransportadora.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_transportadora")
public class Transportadora implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String email;
	private String nome;
	private String empresa;
	private Long telefone;
	private Long celular;
	private Long whatsapp;
	private Long numero;
	
	@ManyToMany
	@JoinTable(name = "tb_transportadora_modal", joinColumns = @JoinColumn(name = "transportadora_id"), inverseJoinColumns = @JoinColumn(name = "modal_id"))
	Set<Modal> modals = new HashSet<>();
	
	public Transportadora () {
		
	}

	public Transportadora(Long id, String email, String nome, String empresa, Long telefone, Long celular,
			Long whatsapp, Long numero) {
		super();
		this.id = id;
		this.email = email;
		this.nome = nome;
		this.empresa = empresa;
		this.telefone = telefone;
		this.celular = celular;
		this.whatsapp = whatsapp;
		this.numero = numero;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public Long getTelefone() {
		return telefone;
	}

	public void setTelefone(Long telefone) {
		this.telefone = telefone;
	}

	public Long getCelular() {
		return celular;
	}

	public void setCelular(Long celular) {
		this.celular = celular;
	}

	public Long getWhatsapp() {
		return whatsapp;
	}

	public void setWhatsapp(Long whatsapp) {
		this.whatsapp = whatsapp;
	}

	public Long getNumero() {
		return numero;
	}

	public void setNumero(Long numero) {
		this.numero = numero;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transportadora other = (Transportadora) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	

}
