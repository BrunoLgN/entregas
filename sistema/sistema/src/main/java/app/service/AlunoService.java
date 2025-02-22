package app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Aluno;
import app.entity.Turma;
import app.repository.AlunoRepository;

@Service
public class AlunoService {
	
	

	@Autowired
	private AlunoRepository alunoRepository;
	
	public String save(Aluno aluno) {
		
		//Regra de negócios 001
		List<Aluno> alunosCadastrados = this.alunoRepository.findByCpf(aluno.getCpf());
		Boolean cpfCadastrado = !alunosCadastrados.isEmpty();
		if(cpfCadastrado ) {
			throw new IllegalArgumentException("CPF já cadastrado!");
		}
		
		//Regra de negócios 002
		if (aluno.getTelefone() == null || aluno.getTelefone().isEmpty()) {
		    aluno.setCadastroCompleto(false);
		} else {
		    aluno.setCadastroCompleto(true);
		}

		
		
		try {
			this.alunoRepository.save(aluno);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return "Aluno " + aluno.getNome() + "salvo com sucesso";
	}
	
	public String update(Aluno aluno, Long id) {
		
		//Regra de negócios 001
		if (aluno.getTelefone() == null || aluno.getTelefone().isEmpty()) {
		    aluno.setCadastroCompleto(false);
		} else {
		    aluno.setCadastroCompleto(true);
		}
		
		
		
		aluno.setId(id);
		try {
			this.alunoRepository.save(aluno);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
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
	
	public List<Aluno> findByNome(String nome){
		return this.alunoRepository.findByNome(nome);
	}
	
	public List<Aluno> findByCpf(String cpf){
		return this.alunoRepository.findByCpf(cpf);
	}
	
	public List<Aluno> findByTurma(long idTurma){
		Turma turma = new Turma();
		turma.setId(idTurma);
		return this.alunoRepository.findByTurma(turma);
	}
	
	public String delete(Long id) {
		this.alunoRepository.deleteById(id);
		return "Aluno excluido com sucesso";
	}
	
	
	public List<Aluno> findByNomeStartingWith(String nome){
			return this.alunoRepository.findByNomeStartingWith(nome);
	}
	
	public List<Aluno> findByTelefoneContaining(String telefone){
		return this.alunoRepository.findByTelefoneContaining(telefone);
	}
	
	public List<Aluno> findByNomeTurma(String nomeTurma){
		return this.alunoRepository.findByNomeTurma(nomeTurma);
	}
	
}
