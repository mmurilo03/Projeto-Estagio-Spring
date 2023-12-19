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
import com.dacproject.dacproject.dtos.AvaliacaoDaEmpresaDTO;
import com.dacproject.dacproject.dtos.EmpresaDTO;
import com.dacproject.dacproject.dtos.EstagioDTO;
import com.dacproject.dacproject.entities.Aluno;
import com.dacproject.dacproject.entities.AvaliacaoDaEmpresa;
import com.dacproject.dacproject.entities.Empresa;
import com.dacproject.dacproject.entities.Estagio;
import com.dacproject.dacproject.repositories.AlunoRepository;
import com.dacproject.dacproject.repositories.AvaliacaoDaEmpresaRepository;
import com.dacproject.dacproject.repositories.EmpresaRepository;
import com.dacproject.dacproject.repositories.EstagioRepository;
import com.dacproject.dacproject.services.execptions.DatabaseException;
import com.dacproject.dacproject.services.execptions.ResourceNotFoundException;

@Service
public class EmpresaService {

	@Autowired
	private EmpresaRepository repository;

	@Autowired
	private AvaliacaoDaEmpresaRepository avaliacaoDaEmpresaRepository;
	@Autowired
	private EstagioRepository estagioRepository;
	@Autowired
	private AlunoRepository alunoRepository;

	@Transactional(readOnly = true)
	public Page<EmpresaDTO> findAllPaged(String nome, String cnpj, Pageable pageable) {

		Page<Empresa> page = repository.find(nome, cnpj, pageable);

		return page.map(x -> new EmpresaDTO(x, x.getAlunos(), x.getEstagios(), x.getAvaliacoesDasEmpresas()));
	}

	@Transactional(readOnly = true)
	public EmpresaDTO findById(Long id) {
		Optional<Empresa> obj = repository.findById(id);
		Empresa entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
		return new EmpresaDTO(entity, entity.getAlunos(), entity.getEstagios(), entity.getAvaliacoesDasEmpresas());
	}

	@Transactional
	public EmpresaDTO insert(EmpresaDTO dto) {
		Empresa entity = new Empresa();
		copyDtoToEntity(dto, entity);
		entity = repository.save(entity);
		return new EmpresaDTO(entity);
	}

	@Transactional
	public EmpresaDTO update(Long id, EmpresaDTO dto) {
		try {
			Empresa entity = repository.getOne(id);
			copyDtoToEntity(dto, entity);
			entity = repository.save(entity);
			return new EmpresaDTO(entity);
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

	private void copyDtoToEntity(EmpresaDTO dto, Empresa entity) {

		entity.setNome(dto.getNome());
		entity.setCnpj(dto.getCnpj());

		entity.getAlunos().clear();
		for (AlunoDTO aluDto : dto.getAlunos()) {
			Aluno aluno = alunoRepository.getOne(aluDto.getId());
			entity.getAlunos().add(aluno);
		}

		entity.getEstagios().clear();
		for (EstagioDTO estDto : dto.getEstagios()) {
			Estagio estagio = estagioRepository.getOne(estDto.getId());
			entity.getEstagios().add(estagio);
		}

		entity.getAvaliacoesDasEmpresas().clear();
		for (AvaliacaoDaEmpresaDTO avalDto : dto.getAvaliacoesDasEmpresas()) {
			AvaliacaoDaEmpresa avaliacaoDaEmpresa = avaliacaoDaEmpresaRepository.getOne(avalDto.getId());
			entity.getAvaliacoesDasEmpresas().add(avaliacaoDaEmpresa);
		}
	}

}
