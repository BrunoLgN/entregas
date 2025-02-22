package app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import app.entity.Turma;
import app.repository.TurmaRepository;

@Service
public class TurmaService {

	@Autowired
	private TurmaRepository turmaRepository;
	
	public String save(Turma turma) {
		
		this.turmaRepository.save(turma);
		return "Turma " + turma.getNome() + "salvo com sucesso";
	}
	
	public String update(Turma turma, Long id) {
		turma.setId(id);
		this.turmaRepository.save(turma);
		return "Turma " + turma.getNome() + "atualizado com sucesso";
	}
	
	public List<Turma> findAll(){
		List<Turma> lista = new ArrayList<>();
		lista = this.turmaRepository.findAll();
		return lista;
	}
	
	public Turma findById(Long id) {
		Turma turma = new Turma();
		turma = this.turmaRepository.findById(id).get();
		return turma;
	}
	
	public String delete(Long id) {
		this.turmaRepository.deleteById(id);
		return "Turma excluido com sucesso";
	}
	
	public List<Turma> findTurmasEntreAnos(int anoInicio, int anoFim){
		return this.turmaRepository.findTurmasEntreAnos(anoInicio, anoFim);
	}
	
	public List<Turma> findTurmaBySemestreAndAno(int semestre, int ano){
		return this.turmaRepository.findTurmaBySemestreAndAno(semestre, ano);
	}
	
	public List<Turma> findTurmaByNomeAndTurno(String nome, String turno){
		return this.turmaRepository.findTurmaByNomeAndTurno(nome, turno);
	}
	
	public List<Turma> findByCursoNome(String nomeCurso){
		return this.turmaRepository.findByCursoNome(nomeCurso);
	}
}
