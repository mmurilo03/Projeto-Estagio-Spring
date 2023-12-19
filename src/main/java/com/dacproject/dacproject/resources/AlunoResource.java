package com.dacproject.dacproject.resources;

import java.net.URI;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.dacproject.dacproject.dtos.AlunoDTO;
import com.dacproject.dacproject.services.AlunoService;

@RestController
@RequestMapping(value = "/alunos")
public class AlunoResource {
	@Autowired
	private AlunoService service;

	@GetMapping
	public ResponseEntity<Page<AlunoDTO>> findAll(
			@RequestParam(value = "estagioId", defaultValue = "0") Long estagioId,
			@RequestParam(value = "avaliacaoDoProfessorId", defaultValue = "0") Long avaliacaoDoProfessorId,
			@RequestParam(value = "avaliacaoDaEmpresaId", defaultValue = "0") Long avaliacaoDaEmpresaId,
			@RequestParam(value = "empresaId", defaultValue = "0") Long empresaId,
			@RequestParam(value = "orientadorId", defaultValue = "0") Long orientadorId,

			@RequestParam(value = "name", defaultValue = "") String nome,
			@RequestParam(value = "matricula", defaultValue = "") String matricula,
			@RequestParam(value = "curso", defaultValue = "") String curso,

			Pageable pageable) {

		Page<AlunoDTO> list = service.findAllPaged(estagioId, avaliacaoDoProfessorId, avaliacaoDaEmpresaId, empresaId,
				orientadorId, nome, matricula, curso, pageable);

		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<AlunoDTO> findById(@PathVariable Long id) {
		AlunoDTO dto = service.findById(id);
		return ResponseEntity.ok().body(dto);
	}

	@PostMapping
	public ResponseEntity<AlunoDTO> insert(@RequestBody AlunoDTO dto, HttpServletRequest request) {
		// var idOrientador = request.getAttribute("orientadorDTO");
		// dto.setOrientadorDTO(orientadorService.findById((Long) idOrientador));
		
		// dto.setOrientadorDTO((Long) idOrientador);
		dto = service.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<AlunoDTO> update(@PathVariable Long id, @RequestBody AlunoDTO dto) {
		dto = service.update(id, dto);
		return ResponseEntity.ok().body(dto);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

}
