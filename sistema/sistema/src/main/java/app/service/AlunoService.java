package app.service;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Aluno;
import app.repository.AlunoRepository;

@Service
public class AlunoService {
	
	

	@Autowired
	private AlunoRepository alunoRepository;
	
	public String save(Aluno aluno) {
		
		this.alunoRepository.save(aluno);
		return "Aluno " + aluno.getNome() + "salvo com sucesso";
	}
	
	public String update(Aluno aluno, Long id) {
		aluno.setId(id);
		this.alunoRepository.save(aluno);
		return "Aluno " + aluno.getNome() + "atualizado com sucesso";
	}
	
	public List<Aluno> findAll(){
		List<Aluno> lista = new ArrayList<>();
		lista = this.alunoRepository.findAll();
		return lista;
	}
	
	public Aluno findById(Long id) {
		Aluno aluno = new Aluno();
		aluno = this.alunoRepository.findById(id).get();
		return aluno;
	}
	
	public String delete(Long id) {
		this.alunoRepository.deleteById(id);
		return "Aluno excluido com sucesso";
	}
}
