package com.dacproject.dacproject.dtos;

import java.io.Serializable;
import com.dacproject.dacproject.entities.Aluno;
import com.dacproject.dacproject.entities.AvaliacaoDaEmpresa;
import com.dacproject.dacproject.entities.AvaliacaoDoProfessor;
import com.dacproject.dacproject.entities.Empresa;
import com.dacproject.dacproject.entities.Estagio;
import com.dacproject.dacproject.entities.Orientador;

public class AlunoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	
	private String nome;

	private String matricula;

	private String curso;

	private EstagioDTO estagioDTO;

	private AvaliacaoDoProfessorDTO avaliacaoDoProfessor;

	private AvaliacaoDaEmpresaDTO avaliacaoDaEmpresa;

	private EmpresaDTO empresaAluno;

	private OrientadorDTO orientadorAluno;
	
	public AlunoDTO() {
	}
	
	public AlunoDTO(Long id, String nome, String matricula, String curso) {
		this.id = id;
		this.nome = nome;
		this.matricula = matricula;
		this.curso = curso;
	}

	public AlunoDTO(Aluno entity) {
		this.id = entity == null ? null : entity.getId();
		this.nome = entity == null ? null : entity.getNome();
		this.matricula = entity == null ? null : entity.getMatricula();
		this.curso = entity == null ? null : entity.getCurso();
		this.estagioDTO = entity.getEstagio() == null ? null : new EstagioAtributosDTO(entity.getEstagio());
		this.avaliacaoDoProfessor = entity.getAvaliacaoDoProfessor() == null ? null : new AvaliacaoDoProfessorAtributosDTO(entity.getAvaliacaoDoProfessor());
		this.avaliacaoDaEmpresa = entity.getAvaliacaoDaEmpresa() == null ? null : new AvaliacaoDaEmpresaAtributosDTO(entity.getAvaliacaoDaEmpresa());
		this.empresaAluno = entity.getEmpresaAluno() == null ? null : new EmpresaAtributosDTO(entity.getEmpresaAluno());
		this.orientadorAluno = entity.getOrientadorAluno() == null ? null : new OrientadorAtributosDTO(entity.getOrientadorAluno());
	}

	public AlunoDTO(Aluno entity, Estagio estagio, AvaliacaoDoProfessor avaliacaoDoProfessor, AvaliacaoDaEmpresa avaliacaoDaEmpresa, 
			Empresa empresa, Orientador orientador) {
		this(entity);
		this.estagioDTO = estagio == null ? null : new EstagioAtributosDTO(estagio);
		this.avaliacaoDoProfessor = avaliacaoDoProfessor == null ? null : new AvaliacaoDoProfessorAtributosDTO(avaliacaoDoProfessor);
		this.avaliacaoDaEmpresa = avaliacaoDaEmpresa == null ? null : new AvaliacaoDaEmpresaAtributosDTO(avaliacaoDaEmpresa);
		this.empresaAluno = empresa == null ? null : new EmpresaAtributosDTO(empresa);
		this.orientadorAluno = orientador == null ? null : new OrientadorAtributosDTO(orientador); 
	}

	public AlunoDTO(Aluno entity, Estagio estagio) {
		this(entity);
		this.estagioDTO = estagio == null ? null : new EstagioDTO(estagio);
	}

	public AlunoDTO(Aluno entity, AvaliacaoDoProfessor avaliacaoDoProfessor) {
		this(entity);
		this.avaliacaoDoProfessor = avaliacaoDoProfessor == null ? null : new AvaliacaoDoProfessorDTO(avaliacaoDoProfessor);
	}

	public AlunoDTO(Aluno entity, AvaliacaoDaEmpresa avaliacaoDaEmpresa) {
		this(entity);
		this.avaliacaoDaEmpresa = avaliacaoDaEmpresa == null ? null : new AvaliacaoDaEmpresaDTO(avaliacaoDaEmpresa);
	}
	
	public AlunoDTO(Aluno entity, Empresa empresaAluno) {
		this(entity);
		this.empresaAluno = empresaAluno == null ? null : new EmpresaDTO(empresaAluno);
	}

	public AlunoDTO(Aluno entity, Orientador orientadorAluno) {
		this(entity);
		this.orientadorAluno = orientadorAluno == null ? null : new OrientadorDTO(orientadorAluno);
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

	public EstagioDTO getEstagio() {
		return estagioDTO;
	}

	public void setEstagio(EstagioDTO estagioDTO) {
		this.estagioDTO = estagioDTO;
	}

	public AvaliacaoDoProfessorDTO getAvaliacaoDoProfessor() {
		return avaliacaoDoProfessor;
	}

	public void setAvaliacaoDoProfessor(AvaliacaoDoProfessorDTO avaliacaoDoProfessor) {
		this.avaliacaoDoProfessor = avaliacaoDoProfessor;
	}

	public AvaliacaoDaEmpresaDTO getAvaliacaoDaEmpresa() {
		return avaliacaoDaEmpresa;
	}

	public void setAvaliacaoDaEmpresa(AvaliacaoDaEmpresaDTO avaliacaoDaEmpresa) {
		this.avaliacaoDaEmpresa = avaliacaoDaEmpresa;
	}

	public EmpresaDTO getEmpresaDTO() {
		return empresaAluno;
	}

	public void setEmpresaDTO(EmpresaDTO empresaAluno) {
		this.empresaAluno = empresaAluno;
	}

	public OrientadorDTO getOrientadorDTO() {
		return orientadorAluno;
	}

	public void setOrientadorDTO(OrientadorDTO orientadorAluno) {
		this.orientadorAluno = orientadorAluno;
	}

}
