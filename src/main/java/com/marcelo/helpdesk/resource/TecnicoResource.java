package com.marcelo.helpdesk.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marcelo.helpdesk.dto.TecnicoDTO;
import com.marcelo.helpdesk.model.Tecnico;
import com.marcelo.helpdesk.services.TecnicoService;

@RestController
@RequestMapping("/tecnicos")
public class TecnicoResource {

	@Autowired
	private TecnicoService service;

	// http://localhost:8080/tecnicos/1
	@GetMapping("/{id}")
	public ResponseEntity<TecnicoDTO> findById(@PathVariable Integer id) {
		Tecnico obj = service.findById(id);
		return ResponseEntity.ok().body(new TecnicoDTO(obj));

	}

	// http://localhost:8080/tecnicos/
//	@GetMapping("/")
//	public List<Tecnico> findAll() {
//		List<Tecnico> tecnicos = service.findAll();
//		return tecnicos;
//
//	}
}
