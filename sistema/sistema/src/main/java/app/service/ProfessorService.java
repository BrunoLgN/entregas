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
		
		//Regra de Negócios 001
		List<Professor> professoresCadastrados = this.professorRepository.findByEmail(professor.getEmail());
		Boolean cpfCadastrado = !professoresCadastrados.isEmpty();
		if(cpfCadastrado ) {
			throw new IllegalArgumentException("Email já cadastrado!");
		}
		
		//Regras de Negócios 002
		String email = professor.getEmail();
	    if (email != null && email.endsWith("@outlook.com")) {
	        throw new RuntimeException("Domínio de e-mail não permitido");
	    }
		
		try {
			this.professorRepository.save(professor);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "Professor " + professor.getNome() + " salvo com sucesso";
	}
	
	public String update(Professor professor, Long id) {
		professor.setId(id);
		try {
			this.professorRepository.save(professor);
		} catch (Exception e) {
			e.printStackTrace();
		}
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
	
	public List<Professor> findByNomeStartingWithOrEspecialidadeStartingWith(String nome, String especialidade){
		List<Professor> lista = new ArrayList<>();
		lista = this.professorRepository.findByNomeStartingWithOrEspecialidadeStartingWith(nome, especialidade);
		return lista;
	}
	
	public List<Professor> findByEmailNotContaining(){
		List<Professor> lista = new ArrayList<>();
		lista = this.professorRepository.findByEmailNotContaining("@gmail.com");
		return lista;
	}
	
	public List<Professor> findByEmail(String email) {
		return this.professorRepository.findByEmail(email);
		
	}
	
}
