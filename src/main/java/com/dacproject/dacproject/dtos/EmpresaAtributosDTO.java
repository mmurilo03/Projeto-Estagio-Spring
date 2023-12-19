package com.dacproject.dacproject.dtos;

import com.dacproject.dacproject.entities.Empresa;

public class EmpresaAtributosDTO extends EmpresaDTO {
	private static final long serialVersionUID = 1L;

	private Long id;
	
	private String nome;

	private String cnpj;
	
	public EmpresaAtributosDTO() {
	}
	
	public EmpresaAtributosDTO(Long id, String nome, String cnpj) {
		this.id = id;
		this.nome = nome;
		this.cnpj = cnpj;
	}

	public EmpresaAtributosDTO(Empresa entity) {
		this.id = entity == null ? null : entity.getId();
		this.nome = entity == null ? null : entity.getNome();
		this.cnpj = entity == null ? null : entity.getCnpj();
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
	
}
