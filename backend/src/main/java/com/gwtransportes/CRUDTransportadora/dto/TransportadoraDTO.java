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
	private String rua;
	private String bairro;
	private String cidade;
	private String estado;
	private Long cep;
	
	private List<ModalDTO> modals = new ArrayList<>();
	
	public TransportadoraDTO () {
		
	}

	public TransportadoraDTO(Long id, String email, String nome, String empresa, Long telefone, Long celular,
			Long whatsapp, Long numero, List<ModalDTO> modals, String rua, String bairro, String cidade, String estado, Long cep) {
		this.id = id;
		this.email = email;
		this.nome = nome;
		this.empresa = empresa;
		this.telefone = telefone;
		this.celular = celular;
		this.whatsapp = whatsapp;
		this.numero = numero;
		this.modals = modals;
		this.rua = rua;
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
		this.cep = cep;
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
		this.rua = entity.getRua();
		this.bairro = entity.getBairro();
		this.cidade = entity.getCidade();
		this.estado = entity.getEstado();
		this.cep = entity.getCep();
		
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

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
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

	public Long getCep() {
		return cep;
	}

	public void setCep(Long cep) {
		this.cep = cep;
	}
	
	
	
	
	

}
