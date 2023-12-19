package com.dacproject.dacproject.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author m
 */

@Entity
@Table(name = "tb_orientador")
public class Orientador implements Serializable {

    private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nome;
    private String matricula;
    
    @OneToMany(mappedBy = "orientadorAluno")
    private List<Aluno> alunos = new ArrayList<>();
    
    @OneToMany(mappedBy = "orientadorEstagio")
    private List<Estagio> estagios = new ArrayList<>();
    
    @OneToMany(mappedBy = "orientador")
    private List<AvaliacaoDoProfessor> avaliacoesDosProfessores = new ArrayList<>();

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

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public List<Estagio> getEstagios() {
        return estagios;
    }
    
    public int getQtdAlunos() {
    	return alunos.size();
    }
    
    public int getQtdAvaliacoes() {
    	return avaliacoesDosProfessores.size();
    }

	public List<AvaliacaoDoProfessor> getAvaliacoesDosProfessores() {
		return avaliacoesDosProfessores;
	}

	public void setAvaliacoesDosProfessores(List<AvaliacaoDoProfessor> avaliacoesDosProfessores) {
		this.avaliacoesDosProfessores = avaliacoesDosProfessores;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	public void setEstagio(List<Estagio> estagios) {
		this.estagios = estagios;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Orientador other = (Orientador) obj;
		return Objects.equals(id, other.id);
	}    
    
    
    
}
