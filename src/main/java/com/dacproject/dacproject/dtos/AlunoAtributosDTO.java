package com.dacproject.dacproject.dtos;

import com.dacproject.dacproject.entities.Aluno;

public class AlunoAtributosDTO extends AlunoDTO {
	private static final long serialVersionUID = 1L;

	private Long id;
	
	private String nome;

	private String matricula;

	private String curso;
	
	public AlunoAtributosDTO() {
	}
	
	public AlunoAtributosDTO(Long id, String nome, String matricula, String curso) {
		this.id = id;
		this.nome = nome;
		this.matricula = matricula;
		this.curso = curso;
	}

	public AlunoAtributosDTO(Aluno entity) {
		this.id = entity == null ? null : entity.getId();
		this.nome = entity == null ? null : entity.getNome();
		this.matricula = entity == null ? null : entity.getMatricula();
		this.curso = entity == null ? null : entity.getCurso();
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

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

}
