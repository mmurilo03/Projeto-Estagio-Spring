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

import com.dacproject.dacproject.dtos.AlunoDTO;
import com.dacproject.dacproject.dtos.AvaliacaoDoProfessorDTO;
import com.dacproject.dacproject.dtos.EstagioDTO;
import com.dacproject.dacproject.dtos.OrientadorDTO;
import com.dacproject.dacproject.entities.Aluno;
import com.dacproject.dacproject.entities.AvaliacaoDoProfessor;
import com.dacproject.dacproject.entities.Estagio;
import com.dacproject.dacproject.entities.Orientador;
import com.dacproject.dacproject.repositories.AlunoRepository;
import com.dacproject.dacproject.repositories.AvaliacaoDoProfessorRepository;
import com.dacproject.dacproject.repositories.EstagioRepository;
import com.dacproject.dacproject.repositories.OrientadorRepository;
import com.dacproject.dacproject.services.execptions.DatabaseException;
import com.dacproject.dacproject.services.execptions.ResourceNotFoundException;

@Service
public class OrientadorService {

	@Autowired
	private OrientadorRepository repository;

	@Autowired
	private AvaliacaoDoProfessorRepository avaliacaoDoProfessorRepository;
	@Autowired
	private EstagioRepository estagioRepository;
	@Autowired
	private AlunoRepository alunoRepository;

	@Transactional(readOnly = true)
	public Page<OrientadorDTO> findAllPaged(String nome, String cnpj, Pageable pageable) {

		Page<Orientador> page = repository.find(nome, cnpj, pageable);
		// Page<Aluno> page = repository.find(nome, matricula, curso, pageable);

		// Page<Aluno> page = repository.findAll(pageable);
		// repository.findAlunoWithEstagio(page.getContent());
		// repository.findAlunoWithAvaliacaoDoProfessor(page.getContent());
		// repository.findAlunoWithAvaliacaoDaEmpresa(page.getContent());
		// repository.findAlunoWithEmpresa(page.getContent());
		// repository.findAlunoWithOrientador(page.getContent());

		return page.map(x -> new OrientadorDTO(x, x.getAlunos(), x.getEstagios(), x.getAvaliacoesDosProfessores()));
	}

	@Transactional(readOnly = true)
	public OrientadorDTO findById(Long id) {
		Optional<Orientador> obj = repository.findById(id);
		Orientador entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
		return new OrientadorDTO(entity, entity.getAlunos(), entity.getEstagios(), entity.getAvaliacoesDosProfessores());
	}

	@Transactional
	public OrientadorDTO insert(OrientadorDTO dto) {
		Orientador entity = new Orientador();
		copyDtoToEntity(dto, entity);
		entity = repository.save(entity);
		return new OrientadorDTO(entity);
	}

	@Transactional
	public OrientadorDTO update(Long id, OrientadorDTO dto) {
		try {
			Orientador entity = repository.getOne(id);
			copyDtoToEntity(dto, entity);
			entity = repository.save(entity);
			return new OrientadorDTO(entity);
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

	private void copyDtoToEntity(OrientadorDTO dto, Orientador entity) {

		entity.setNome(dto.getNome());
		entity.setMatricula(dto.getMatricula());

		entity.getAlunos().clear();
		for (AlunoDTO aluDto : dto.getAlunos()) {
			Aluno aluno = alunoRepository.getOne(aluDto.getId());
			System.out.println(aluno.getNome());
			entity.getAlunos().add(aluno);
		}

		entity.getEstagios().clear();
		for (EstagioDTO estDto : dto.getEstagios()) {
			Estagio estagio = estagioRepository.getOne(estDto.getId());
			entity.getEstagios().add(estagio);
		}

		entity.getAvaliacoesDosProfessores().clear();
		for (AvaliacaoDoProfessorDTO avalDto : dto.getAvaliacaoDoProfessores()) {
			AvaliacaoDoProfessor avaliacaoDoProfessor = avaliacaoDoProfessorRepository.getOne(avalDto.getId());
			entity.getAvaliacoesDosProfessores().add(avaliacaoDoProfessor);
		}
	}

}
