package app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Professor;
import app.repository.ProfessorRepository;

@Service
public class ProfessorService {

	@Autowired
	private ProfessorRepository professorRepository;
	
	public String save(Professor professor) {
		
		this.professorRepository.save(professor);
		return "Professor " + professor.getNome() + " salvo com sucesso";
	}
	
	public String update(Professor professor, Long id) {
		professor.setId(id);
		this.professorRepository.save(professor);
		return "Professor " + professor.getNome() + " atualizado com sucesso";
	}
	
	public List<Professor> findAll(){
		List<Professor> lista = new ArrayList<>();
		lista = this.professorRepository.findAll();
		return lista;
	}
	
	public Professor findById(Long id) {
		Professor professor = new Professor();
		professor = this.professorRepository.findById(id).get();
		return professor;
	}
	
	public String delete(Long id) {
		this.professorRepository.deleteById(id);
		return "Professor excluido com sucesso";
	}
}
