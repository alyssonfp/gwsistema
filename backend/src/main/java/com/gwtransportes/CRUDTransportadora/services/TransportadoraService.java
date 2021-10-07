package com.gwtransportes.CRUDTransportadora.services;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.gwtransportes.CRUDTransportadora.dto.TransportadoraDTO;
import com.gwtransportes.CRUDTransportadora.entities.Transportadora;
import com.gwtransportes.CRUDTransportadora.repositories.TransportadoraRepository;
import com.gwtransportes.CRUDTransportadora.services.excepetions.DatabaseException;
import com.gwtransportes.CRUDTransportadora.services.excepetions.ResourceNotFoundException;




@Service
public class TransportadoraService {
	
	@Autowired
	private TransportadoraRepository repository;
	
	@Transactional(readOnly = true)
	public List<TransportadoraDTO> findAll() {
		List<Transportadora> list = repository.findAll();
		return list.stream().map(x -> new TransportadoraDTO(x)).collect(Collectors.toList());
	}
	@Transactional
	public TransportadoraDTO insert(TransportadoraDTO dto) {
		Transportadora entity = new Transportadora();
		entity.setNome(dto.getNome());
		entity = repository.save(entity);
		return new TransportadoraDTO(entity);
	}

	@Transactional
	public TransportadoraDTO update(Long id, TransportadoraDTO dto) {
		try {
			Transportadora entity = repository.getOne(id);
			entity.setNome(dto.getNome());
			entity = repository.save(entity);
			return new TransportadoraDTO(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id not found " + id);
		}
	}

	public void delete(Long id) {
		try {
			repository.deleteById(id);
		}
		catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Id not found " + id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DatabaseException("Integrity violation");
		}
	}

	


}
