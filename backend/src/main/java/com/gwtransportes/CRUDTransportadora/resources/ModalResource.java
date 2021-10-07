package com.gwtransportes.CRUDTransportadora.resources;


import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import com.gwtransportes.CRUDTransportadora.dto.ModalDTO;
import com.gwtransportes.CRUDTransportadora.services.ModalService;



@RestController
@RequestMapping(value = "/modals")
public class ModalResource {
	
	@Autowired
	private ModalService service;
	
	@GetMapping
	public ResponseEntity<List<ModalDTO>> findAll() {
		List<ModalDTO> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	@PostMapping
	public ResponseEntity<ModalDTO> insert(@RequestBody ModalDTO dto) {
		dto = service.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<ModalDTO> update(@PathVariable Long id, @RequestBody ModalDTO dto) {
		dto = service.update(id, dto);
		return ResponseEntity.ok().body(dto);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<ModalDTO> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	

	

}
