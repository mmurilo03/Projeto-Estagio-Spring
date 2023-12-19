package com.dacproject.dacproject.services;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dacproject.dacproject.dtos.AvaliacaoDoProfessorDTO;
import com.dacproject.dacproject.entities.Aluno;
import com.dacproject.dacproject.entities.AvaliacaoDoProfessor;
import com.dacproject.dacproject.entities.Orientador;
import com.dacproject.dacproject.repositories.AlunoRepository;
import com.dacproject.dacproject.repositories.AvaliacaoDoProfessorRepository;
import com.dacproject.dacproject.repositories.OrientadorRepository;
import com.dacproject.dacproject.services.execptions.DatabaseException;
import com.dacproject.dacproject.services.execptions.ResourceNotFoundException;

@Service
public class AvaliacaoDoProfessorService {

	@Autowired
	private AvaliacaoDoProfessorRepository repository;

	@Autowired
	private AlunoRepository alunoRepository;
	@Autowired
	private OrientadorRepository orientadorRepository;

	@Transactional(readOnly = true)
	public Page<AvaliacaoDoProfessorDTO> findAllPaged(Pageable pageable) {
		Page<AvaliacaoDoProfessor> list = repository.findAll(pageable);
		return list.map(x -> new AvaliacaoDoProfessorDTO(x));
	}

	@Transactional(readOnly = true)
	public AvaliacaoDoProfessorDTO findById(Long id) {
		Optional<AvaliacaoDoProfessor> obj = repository.findById(id);
		AvaliacaoDoProfessor entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
		return new AvaliacaoDoProfessorDTO(entity);
	}

	@Transactional
	public AvaliacaoDoProfessorDTO insert(AvaliacaoDoProfessorDTO dto) {
		AvaliacaoDoProfessor entity = new AvaliacaoDoProfessor();
		copyDtoToEntity(dto, entity);
		entity = repository.save(entity);
		return new AvaliacaoDoProfessorDTO(entity);
	}

	@Transactional
	public AvaliacaoDoProfessorDTO update(Long id, AvaliacaoDoProfessorDTO dto) {
		try {
			AvaliacaoDoProfessor entity = repository.getOne(id);
			copyDtoToEntity(dto, entity);
			entity = repository.save(entity);
			return new AvaliacaoDoProfessorDTO(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id not found " + id);
		}
	}

	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Id not found " + id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException("Integrity violation");
		}
	}

	private void copyDtoToEntity(AvaliacaoDoProfessorDTO dto, AvaliacaoDoProfessor entity) {

		entity.setAssiduidade(dto.getAssiduidade());
		entity.setDisciplina(dto.getDisciplina());
		entity.setSociabilidade(dto.getSociabilidade());
		entity.setResponsabilidade(dto.getResponsabilidade());
		entity.setIniciativa(dto.getIniciativa());
		
		Orientador orientador = orientadorRepository.getOne(dto.getOrientador().getId());
		Aluno aluno = alunoRepository.getOne(dto.getAluno().getId());

		entity.setOrientador(orientador);
		entity.setAluno(aluno);
	}

}
