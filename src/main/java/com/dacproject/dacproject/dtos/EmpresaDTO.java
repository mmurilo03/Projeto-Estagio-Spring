package com.dacproject.dacproject.dtos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.dacproject.dacproject.entities.Aluno;
import com.dacproject.dacproject.entities.AvaliacaoDaEmpresa;
import com.dacproject.dacproject.entities.Empresa;
import com.dacproject.dacproject.entities.Estagio;

public class EmpresaDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	
	private String nome;

	private String cnpj;

	private List<AlunoDTO> alunos = new ArrayList<>();

	private List<EstagioDTO> estagios = new ArrayList<>();

	private List<AvaliacaoDaEmpresaDTO> avaliacoesDasEmpresas = new ArrayList<>();
	
	public EmpresaDTO() {
	}
	
	public EmpresaDTO(Long id, String nome, String cnpj) {
		this.id = id;
		this.nome = nome;
		this.cnpj = cnpj;
	}

	public EmpresaDTO(Empresa entity) {
		this.id = entity.getId();
		this.nome = entity.getNome();
		this.cnpj = entity.getCnpj();
	}

	public EmpresaDTO(Empresa entity, List<Aluno> alunos, List<Estagio> estagios, List<AvaliacaoDaEmpresa> avaliacoesDasEmpresas) {
		this(entity);
		alunos.forEach(alu -> this.alunos.add(new AlunoAtributosDTO(alu)));
		estagios.forEach(est -> this.estagios.add(new EstagioAtributosDTO(est)));
		avaliacoesDasEmpresas.forEach(aval -> this.avaliacoesDasEmpresas.add(new AvaliacaoDaEmpresaAtributosDTO(aval)));
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public List<AlunoDTO> getAlunos() {
		return alunos;
	}

	public void setAlunos(List<AlunoDTO> alunos) {
		this.alunos = alunos;
	}

	public List<EstagioDTO> getEstagios() {
		return estagios;
	}

	public void setEstagios(List<EstagioDTO> estagios) {
		this.estagios = estagios;
	}

	public List<AvaliacaoDaEmpresaDTO> getAvaliacoesDasEmpresas() {
		return avaliacoesDasEmpresas;
	}

	public void setAvaliacoesDasEmpresas(List<AvaliacaoDaEmpresaDTO> avaliacoesDasEmpresas) {
		this.avaliacoesDasEmpresas = avaliacoesDasEmpresas;
	}

	
}
