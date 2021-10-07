package com.gwtransportes.CRUDTransportadora.dto;

import java.io.Serializable;

import com.gwtransportes.CRUDTransportadora.entities.Modal;

public class ModalDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String tipo;
	
	public ModalDTO() {
		
	}

	public ModalDTO(Long id, String tipo) {
		this.id = id;
		this.tipo = tipo;
	}
	public ModalDTO(Modal entity) {
		this.id = entity.getId();
		this.tipo = entity.getTipo();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	

}
