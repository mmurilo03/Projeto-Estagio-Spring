package com.dacproject.dacproject.dtos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.dacproject.dacproject.entities.Aluno;
import com.dacproject.dacproject.entities.AvaliacaoDoProfessor;
import com.dacproject.dacproject.entities.Estagio;
import com.dacproject.dacproject.entities.Orientador;

public class OrientadorDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	
	private String nome;

	private String matricula;

	private List<AlunoDTO> alunos = new ArrayList<>();

	private List<EstagioDTO> estagios = new ArrayList<>();

	private List<AvaliacaoDoProfessorDTO> avaliacaoDoProfessores = new ArrayList<>();
	
	public OrientadorDTO() {
	}
	
	public OrientadorDTO(Long id, String nome, String matricula) {
		this.id = id;
		this.nome = nome;
		this.matricula = matricula;
	}

	public OrientadorDTO(Orientador entity) {
		this.id = entity.getId();
		this.nome = entity.getNome();
		this.matricula = entity.getMatricula();
	}

	public OrientadorDTO(Orientador entity, List<Aluno> alunos, List<Estagio> estagios, List<AvaliacaoDoProfessor> avaliacaoDoProfessores) {
		this(entity);
		alunos.forEach(alu -> this.alunos.add(new AlunoAtributosDTO(alu)));
		estagios.forEach(est -> this.estagios.add(new EstagioAtributosDTO(est)));
		avaliacaoDoProfessores.forEach(aval -> this.avaliacaoDoProfessores.add(new AvaliacaoDoProfessorAtributosDTO(aval)));
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

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
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

	public List<AvaliacaoDoProfessorDTO> getAvaliacaoDoProfessores() {
		return avaliacaoDoProfessores;
	}

	public void setAvaliacaoDoProfessores(List<AvaliacaoDoProfessorDTO> avaliacaoDoProfessores) {
		this.avaliacaoDoProfessores = avaliacaoDoProfessores;
	}

	

}
