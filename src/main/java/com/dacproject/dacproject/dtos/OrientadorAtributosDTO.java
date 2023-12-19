package com.dacproject.dacproject.dtos;

import com.dacproject.dacproject.entities.Orientador;

public class OrientadorAtributosDTO extends OrientadorDTO {
	private static final long serialVersionUID = 1L;

	private Long id;
	
	private String nome;

	private String matricula;
	
	public OrientadorAtributosDTO() {
	}
	
	public OrientadorAtributosDTO(Long id, String nome, String matricula) {
		this.id = id;
		this.nome = nome;
		this.matricula = matricula;
	}

	public OrientadorAtributosDTO(Orientador entity) {
		this.id = entity == null ? null : entity.getId();
		this.nome = entity == null ? null : entity.getNome();
		this.matricula = entity == null ? null : entity.getMatricula();
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

}
