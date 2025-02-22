package app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Curso;
import app.repository.CursoRepository;

@Service
public class CursoService {
	
	@Autowired
	private CursoRepository cursoRepository;
	
	public String save(Curso curso) {
		
		this.cursoRepository.save(curso);
		return "Curso " + curso.getNome() + "salvo com sucesso";
	}
	
	public String update(Curso curso, Long id) {
		curso.setId(id);
		this.cursoRepository.save(curso);
		return "Curso " + curso.getNome() + "atualizado com sucesso";
	}
	
	public List<Curso> findAll(){
		List<Curso> lista = new ArrayList<>();
		lista = this.cursoRepository.findAll();
		return lista;
	}
	
	public Curso findById(Long id) {
		Curso curso = new Curso();
		curso = this.cursoRepository.findById(id).get();
		return curso;
	}
	
	public String delete(Long id) {
		this.cursoRepository.deleteById(id);
		return "Curso excluido com sucesso";
	}
	
	public List<Curso> findByNomeIgnoreCase(String nome) {
		return this.cursoRepository.findByNomeIgnoreCase(nome);
	}

}
