package com.gwtransportes.CRUDTransportadora.services;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.gwtransportes.CRUDTransportadora.dto.ModalDTO;
import com.gwtransportes.CRUDTransportadora.entities.Modal;
import com.gwtransportes.CRUDTransportadora.repositories.ModalRepository;
import com.gwtransportes.CRUDTransportadora.services.excepetions.DatabaseException;
import com.gwtransportes.CRUDTransportadora.services.excepetions.ResourceNotFoundException;




@Service
public class ModalService {
	
	@Autowired
	private ModalRepository repository;
	
	@Transactional(readOnly = true)
	public List<ModalDTO> findAll() {
		List<Modal> list = repository.findAll();
		return list.stream().map(x -> new ModalDTO(x)).collect(Collectors.toList());
	}
	@Transactional
	public ModalDTO insert(ModalDTO dto) {
		Modal entity = new Modal();
		entity.setTipo(dto.getTipo());
		entity = repository.save(entity);
		return new ModalDTO(entity);
	}

	@Transactional
	public ModalDTO update(Long id, ModalDTO dto) {
		try {
			Modal entity = repository.getOne(id);
			entity.setTipo(dto.getTipo());
			entity = repository.save(entity);
			return new ModalDTO(entity);
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
