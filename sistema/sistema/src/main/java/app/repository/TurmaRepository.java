package app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import app.entity.Turma;

public interface TurmaRepository extends JpaRepository<Turma, Long>{
	
    @Query("SELECT t FROM Turma t WHERE t.ano BETWEEN :anoInicio AND :anoFim")
	public List<Turma> findTurmasEntreAnos(int anoInicio, int anoFim);
    
    public List<Turma> findTurmaBySemestreAndAno(int semestre, int ano);
    
    public List<Turma> findTurmaByNomeAndTurno(String nome, String turno);
    
    public List<Turma> findByCursoNome(String nomeCurso);

}
