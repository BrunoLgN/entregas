package app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import app.entity.Aluno;
import app.entity.Turma;

public interface AlunoRepository extends JpaRepository<Aluno, Long>{
	
	public List<Aluno> findByNome(String nome);
	
	public List<Aluno> findByTurma(Turma turma);
	
	public List<Aluno> findByCpf(String cpf);
	
	public List<Aluno> findByNomeStartingWith(String nome);
	
	public List<Aluno> findByTelefoneContaining(String telefone);
	
	@Query("SELECT a FROM Aluno a where a.turma.nome =:nomeTurma")
	List<Aluno> findByNomeTurma(String nomeTurma);

}
