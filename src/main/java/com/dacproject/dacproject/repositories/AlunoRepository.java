package com.dacproject.dacproject.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.dacproject.dacproject.entities.Aluno;
import com.dacproject.dacproject.entities.AvaliacaoDaEmpresa;
import com.dacproject.dacproject.entities.AvaliacaoDoProfessor;
import com.dacproject.dacproject.entities.Empresa;
import com.dacproject.dacproject.entities.Estagio;
import com.dacproject.dacproject.entities.Orientador;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {

	@Query("SELECT DISTINCT alu FROM Aluno alu "
        + "LEFT JOIN alu.estagio est "
        + "LEFT JOIN alu.avaliacaoDoProfessor avp "
        + "LEFT JOIN alu.avaliacaoDaEmpresa ave "
        + "LEFT JOIN alu.empresaAluno emp "
        + "LEFT JOIN alu.orientadorAluno ori WHERE "
        + "(COALESCE(:estagio) IS NULL OR est.id IN :estagio) AND "
        + "(COALESCE(:avaliacaoDoProfessor) IS NULL OR avp.id IN :avaliacaoDoProfessor) AND "
        + "(COALESCE(:avaliacaoDaEmpresa) IS NULL OR ave.id IN :avaliacaoDaEmpresa) AND "
        + "(COALESCE(:empresaAluno) IS NULL OR emp.id IN :empresaAluno) AND "
        + "(COALESCE(:orientadorAluno) IS NULL OR ori.id IN :orientadorAluno) AND "
        + "(LOWER(alu.nome) LIKE LOWER(CONCAT('%',:nome,'%'))) AND "
        + "(LOWER(alu.matricula) LIKE LOWER(CONCAT('%',:matricula,'%'))) AND "
        + "(LOWER(alu.curso) LIKE LOWER(CONCAT('%',:curso,'%'))) ")
	Page<Aluno> find(String nome, String matricula, String curso, Estagio estagio,
			AvaliacaoDoProfessor avaliacaoDoProfessor,
			AvaliacaoDaEmpresa avaliacaoDaEmpresa, Empresa empresaAluno, Orientador orientadorAluno, Pageable pageable);
	
	@Query("SELECT alu FROM Aluno alu JOIN FETCH alu.estagio WHERE alu IN :alunos")
	List<Aluno> findAlunoWithEstagio( List<Aluno> alunos);

	 
	@Query("SELECT alu FROM Aluno alu JOIN FETCH alu.avaliacaoDoProfessor WHERE alu IN :alunos")
	List<Aluno> findAlunoWithAvaliacaoDoProfessor( List<Aluno> alunos);

	 
	@Query("SELECT alu FROM Aluno alu JOIN FETCH alu.avaliacaoDaEmpresa WHERE alu IN :alunos")
	List<Aluno> findAlunoWithAvaliacaoDaEmpresa( List<Aluno> alunos);

	 
	@Query("SELECT alu FROM Aluno alu JOIN FETCH alu.empresaAluno WHERE alu IN :alunos")
	List<Aluno> findAlunoWithEmpresa( List<Aluno> alunos);

	 
	@Query("SELECT alu FROM Aluno alu JOIN FETCH alu.orientadorAluno WHERE alu IN :alunos")
	List<Aluno> findAlunoWithOrientador( List<Aluno> alunos);

}
