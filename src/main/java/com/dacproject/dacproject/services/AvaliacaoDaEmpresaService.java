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

import com.dacproject.dacproject.dtos.AvaliacaoDaEmpresaDTO;
import com.dacproject.dacproject.entities.Aluno;
import com.dacproject.dacproject.entities.AvaliacaoDaEmpresa;
import com.dacproject.dacproject.entities.Empresa;
import com.dacproject.dacproject.repositories.AlunoRepository;
import com.dacproject.dacproject.repositories.AvaliacaoDaEmpresaRepository;
import com.dacproject.dacproject.repositories.EmpresaRepository;
import com.dacproject.dacproject.services.execptions.DatabaseException;
import com.dacproject.dacproject.services.execptions.ResourceNotFoundException;

@Service
public class AvaliacaoDaEmpresaService {

	@Autowired
	private AvaliacaoDaEmpresaRepository repository;

	@Autowired
	private AlunoRepository alunoRepository;
	@Autowired
	private EmpresaRepository empresaRepository;

	@Transactional(readOnly = true)
	public Page<AvaliacaoDaEmpresaDTO> findAllPaged(Pageable pageable) {
		Page<AvaliacaoDaEmpresa> list = repository.findAll(pageable);
		return list.map(x -> new AvaliacaoDaEmpresaDTO(x));
	}

	@Transactional(readOnly = true)
	public AvaliacaoDaEmpresaDTO findById(Long id) {
		Optional<AvaliacaoDaEmpresa> obj = repository.findById(id);
		AvaliacaoDaEmpresa entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
		return new AvaliacaoDaEmpresaDTO(entity);
	}

	@Transactional
	public AvaliacaoDaEmpresaDTO insert(AvaliacaoDaEmpresaDTO dto) {
		AvaliacaoDaEmpresa entity = new AvaliacaoDaEmpresa();
		copyDtoToEntity(dto, entity);
		entity = repository.save(entity);
		return new AvaliacaoDaEmpresaDTO(entity);
	}

	@Transactional
	public AvaliacaoDaEmpresaDTO update(Long id, AvaliacaoDaEmpresaDTO dto) {
		try {
			AvaliacaoDaEmpresa entity = repository.getOne(id);
			copyDtoToEntity(dto, entity);
			entity = repository.save(entity);
			return new AvaliacaoDaEmpresaDTO(entity);
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

	private void copyDtoToEntity(AvaliacaoDaEmpresaDTO dto, AvaliacaoDaEmpresa entity) {

		entity.setRendimentoDeTrabalho(dto.getRendimentoDeTrabalho());
		entity.setConhecimentos(dto.getConhecimentos());
		entity.setCumprimentoDasTarefas(dto.getCumprimentoDasTarefas());
		entity.setAprendizagem(dto.getAprendizagem());
		entity.setDesempenho(dto.getDesempenho());
		
		Empresa empresa = empresaRepository.getOne(dto.getEmpresa().getId());
		Aluno aluno = alunoRepository.getOne(dto.getAluno().getId());

		entity.setEmpresa(empresa);
		entity.setAluno(aluno);

	}

}
