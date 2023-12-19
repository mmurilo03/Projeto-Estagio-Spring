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
import com.dacproject.dacproject.entities.Aluno;
import com.dacproject.dacproject.entities.AvaliacaoDaEmpresa;
import com.dacproject.dacproject.entities.AvaliacaoDoProfessor;
import com.dacproject.dacproject.entities.Empresa;
import com.dacproject.dacproject.entities.Estagio;
import com.dacproject.dacproject.entities.Orientador;
import com.dacproject.dacproject.repositories.AlunoRepository;
import com.dacproject.dacproject.repositories.AvaliacaoDaEmpresaRepository;
import com.dacproject.dacproject.repositories.AvaliacaoDoProfessorRepository;
import com.dacproject.dacproject.repositories.EmpresaRepository;
import com.dacproject.dacproject.repositories.EstagioRepository;
import com.dacproject.dacproject.repositories.OrientadorRepository;
import com.dacproject.dacproject.services.execptions.DatabaseException;
import com.dacproject.dacproject.services.execptions.ResourceNotFoundException;

@Service
public class AlunoService {

	@Autowired
	private AlunoRepository repository;

	@Autowired
	private AvaliacaoDaEmpresaRepository avaliacaoDaEmpresaRepository;	
	@Autowired
	private AvaliacaoDoProfessorRepository avaliacaoDoProfessorRepository;
	@Autowired
	private EmpresaRepository empresaRepository;
	@Autowired
	private EstagioRepository estagioRepository;
	@Autowired
	private OrientadorRepository orientadorRepository;

	@Transactional(readOnly = true)
	public Page<AlunoDTO> findAllPaged(Pageable pageable) {
		Page<Aluno> list = repository.findAll(pageable);
		return list.map(x -> new AlunoDTO(x));
	}

	@Transactional(readOnly = true)
	public Page<AlunoDTO> findAllPaged(Long estagioId, Long avaliacaoDoProfessorId,
		Long avaliacaoDaEmpresaId, Long empresaId, Long orientadorId, String nome, String matricula, String curso, Pageable pageable) {

		Estagio estagio = (estagioId == 0) ? null : estagioRepository.getOne(estagioId);
		AvaliacaoDoProfessor avaliacaoDoProfessor = (avaliacaoDoProfessorId == 0) ? null : avaliacaoDoProfessorRepository.getOne(avaliacaoDoProfessorId);
		AvaliacaoDaEmpresa avaliacaoDaEmpresa = (avaliacaoDaEmpresaId == 0) ? null : avaliacaoDaEmpresaRepository.getOne(avaliacaoDaEmpresaId);
		Empresa empresa = (empresaId == 0) ? null : empresaRepository.getOne(empresaId);
		Orientador orientador = (orientadorId == 0) ? null : orientadorRepository.getOne(orientadorId);


		Page<Aluno> page = repository.find(nome, matricula, curso, estagio, avaliacaoDoProfessor, avaliacaoDaEmpresa, empresa, orientador, pageable);

		repository.findAlunoWithEstagio(page.getContent());
		repository.findAlunoWithAvaliacaoDoProfessor(page.getContent());
		repository.findAlunoWithAvaliacaoDaEmpresa(page.getContent());
		repository.findAlunoWithEmpresa(page.getContent());
		repository.findAlunoWithOrientador(page.getContent());

		return page.map(x -> new AlunoDTO(x, x.getEstagio(), x.getAvaliacaoDoProfessor(), x.getAvaliacaoDaEmpresa(),  x.getEmpresaAluno(), x.getOrientadorAluno()));
	}

	@Transactional(readOnly = true)
	public AlunoDTO findById(Long id) {
		Optional<Aluno> obj = repository.findById(id);
		Aluno entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
		return new AlunoDTO(entity, entity.getEstagio(), entity.getAvaliacaoDoProfessor(), entity.getAvaliacaoDaEmpresa(),
				entity.getEmpresaAluno(),
				entity.getOrientadorAluno());
	}

	@Transactional
	public AlunoDTO insert(AlunoDTO dto) {
		Aluno entity = new Aluno();
		copyDtoToEntity(dto, entity);
		entity = repository.save(entity);
		return new AlunoDTO(entity);
	}

	@Transactional
	public AlunoDTO update(Long id, AlunoDTO dto) {
		try {
			Aluno entity = repository.getOne(id);
			copyDtoToEntity(dto, entity);

			entity = repository.save(entity);
			return new AlunoDTO(entity);
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

	private void copyDtoToEntity(AlunoDTO dto, Aluno entity) {

		entity.setNome(dto.getNome());
		entity.setMatricula(dto.getMatricula());
		entity.setCurso(dto.getCurso());

		Estagio estagio = dto.getEstagio() == null ? null : estagioRepository.getOne(dto.getEstagio().getId());
		AvaliacaoDoProfessor avaliacaoDoProfessor = dto.getAvaliacaoDoProfessor() == null ? null : avaliacaoDoProfessorRepository.getOne(dto.getAvaliacaoDoProfessor().getId());
		AvaliacaoDaEmpresa avaliacaoDaEmpresa = dto.getAvaliacaoDaEmpresa() == null ? null : avaliacaoDaEmpresaRepository.getOne(dto.getAvaliacaoDaEmpresa().getId());
		Empresa empresa = dto.getEmpresaDTO() == null ? null : empresaRepository.getOne(dto.getEmpresaDTO().getId());
		Orientador orientador = dto.getOrientadorDTO() == null ? null : orientadorRepository.getOne(dto.getOrientadorDTO().getId());

		entity.setEstagio(estagio);
		entity.setAvaliacaoDoProfessor(avaliacaoDoProfessor);
		entity.setAvaliacaoDaEmpresa(avaliacaoDaEmpresa);
		entity.setEmpresaAluno(empresa);
		entity.setOrientadorAluno(orientador);
	}

}
