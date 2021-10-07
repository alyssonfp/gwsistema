package com.gwtransportes.CRUDTransportadora.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import com.gwtransportes.CRUDTransportadora.entities.Modal;
import com.gwtransportes.CRUDTransportadora.entities.Transportadora;

public class TransportadoraDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String email;
	private String nome;
	private String empresa;
	private Long telefone;
	private Long celular;
	private Long whatsapp;
	private Long numero;
	
	private List<ModalDTO> modals = new ArrayList<>();
	
	public TransportadoraDTO () {
		
	}

	public TransportadoraDTO(Long id, String email, String nome, String empresa, Long telefone, Long celular,
			Long whatsapp, Long numero, List<ModalDTO> modals) {
		super();
		this.id = id;
		this.email = email;
		this.nome = nome;
		this.empresa = empresa;
		this.telefone = telefone;
		this.celular = celular;
		this.whatsapp = whatsapp;
		this.numero = numero;
		this.modals = modals;
	}
	
	public TransportadoraDTO(Transportadora entity) {
		this.id = entity.getId();
		this.email = entity.getEmail();
		this.nome = entity.getNome();
		this.empresa = entity.getEmpresa();
		this.telefone = entity.getTelefone();
		this.celular = entity.getCelular();
		this.whatsapp = entity.getWhatsapp();
		this.numero = entity.getNumero();
		
	}
	
	public TransportadoraDTO(Transportadora entity, Set<Modal> modals) {
		this(entity);
		modals.forEach(cat -> this.modals.add(new ModalDTO(cat)));
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

	public List<ModalDTO> getModals() {
		return modals;
	}

	public void setModals(List<ModalDTO> modals) {
		this.modals = modals;
	}
	
	
	
	

}
