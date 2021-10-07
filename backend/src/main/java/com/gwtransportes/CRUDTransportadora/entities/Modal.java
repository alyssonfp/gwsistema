package com.gwtransportes.CRUDTransportadora.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name= "tb_modal")
public class Modal implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String tipo;
	
	@ManyToMany(mappedBy = "modals")
	private Set<Transportadora> transportadoras = new HashSet<>();
	
	public Modal () {
		
	}

	public Modal(Long id, String tipo, Set<Transportadora> transportadoras) {
		super();
		this.id = id;
		this.tipo = tipo;
		this.transportadoras = transportadoras;
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

	public Set<Transportadora> getTransportadoras() {
		return transportadoras;
	}

	public void setTransportadoras(Set<Transportadora> transportadoras) {
		this.transportadoras = transportadoras;
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
		Modal other = (Modal) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	

}
