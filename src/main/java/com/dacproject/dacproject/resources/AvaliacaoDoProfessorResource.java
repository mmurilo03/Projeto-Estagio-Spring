package com.dacproject.dacproject.resources;

import java.net.URI;

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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.dacproject.dacproject.dtos.AlunoDTO;
import com.dacproject.dacproject.dtos.AvaliacaoDoProfessorDTO;
import com.dacproject.dacproject.services.AlunoService;
import com.dacproject.dacproject.services.AvaliacaoDoProfessorService;

@RestController
@RequestMapping(value = "/avaliacoesdoprofessor")
public class AvaliacaoDoProfessorResource {
    @Autowired
	private AvaliacaoDoProfessorService service;

	@Autowired
	private AlunoService alunoService;
	
	@GetMapping
	public ResponseEntity<Page<AvaliacaoDoProfessorDTO>> findAll(Pageable pageable) {
		Page<AvaliacaoDoProfessorDTO> list = service.findAllPaged(pageable);		
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<AvaliacaoDoProfessorDTO> findById(@PathVariable Long id) {
		AvaliacaoDoProfessorDTO dto = service.findById(id);
		return ResponseEntity.ok().body(dto);
	}
	
	@PostMapping
	public ResponseEntity<AvaliacaoDoProfessorDTO> insert(@RequestBody AvaliacaoDoProfessorDTO dto) {
		AlunoDTO aluno = alunoService.findById(dto.getAluno().getId());
		if (aluno.getAvaliacaoDaEmpresa() != null) {
			return ResponseEntity.badRequest().build();
		}
		dto = service.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<AvaliacaoDoProfessorDTO> update(@PathVariable Long id, @RequestBody AvaliacaoDoProfessorDTO dto) {
		dto = service.update(id, dto);
		return ResponseEntity.ok().body(dto);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
  
    
}
