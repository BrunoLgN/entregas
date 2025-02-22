package app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import app.entity.Aluno;
import app.service.AlunoService;

@RestController
@RequestMapping("api/aluno")
public class AlunoController {

	@Autowired
	private AlunoService alunoService;
	
	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody Aluno aluno){
		try {
			String mensagem = this.alunoService.save(aluno);
			return new ResponseEntity<>(mensagem, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<String> update(@RequestBody Aluno aluno, @PathVariable Long id){
		try {
			String mensagem = this.alunoService.update(aluno, id);
			return new ResponseEntity<>(mensagem, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

		}
	}
	
	@GetMapping("/findById/{id}")
	public ResponseEntity<Aluno> findById(@PathVariable long id){
		try {
			Aluno aluno = this.alunoService.findById(id);
			return new ResponseEntity<>(aluno, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/findAll")
	public ResponseEntity<List<Aluno>> findAll(){
		try {
			List<Aluno> lista = this.alunoService.findAll();
			return new ResponseEntity<>(lista, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable long id){
		try {
			
			String mensagem = this.alunoService.delete(id);
			return new ResponseEntity<>(mensagem, HttpStatus.OK );
			
		} catch (Exception e) {
			
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST );

		}
	}
	
	@GetMapping("/findByNome")
	public ResponseEntity<List<Aluno>> findByNome(@RequestParam String nome){
		try {
			List<Aluno> lista = this.alunoService.findByNome(nome);
			return new ResponseEntity<>(lista, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/findByTurma")
	public ResponseEntity<List<Aluno>> findByTurma(@RequestParam long idTurma){
		try {
			List<Aluno> lista = this.alunoService.findByTurma(idTurma);
			return new ResponseEntity<>(lista, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/findByComecoNome/{nome}")
	public ResponseEntity<List<Aluno>> findByNomeStartingWith(@PathVariable String nome){
		try {
			List<Aluno> lista = this.alunoService.findByNomeStartingWith(nome);
			return new ResponseEntity<>(lista, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/findByTelefoneContaining/{telefone}")
	public ResponseEntity<List<Aluno>> findByTelefoneContaining(@PathVariable String telefone){
		try {
			List<Aluno> lista = this.alunoService.findByTelefoneContaining(telefone);
			return new ResponseEntity<>(lista, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/findByNomeTurma/{nomeTurma}")
	public ResponseEntity<List<Aluno>> findByNomeTurma(@PathVariable String nomeTurma){
		try {
			List<Aluno> lista = this.alunoService.findByNomeTurma(nomeTurma);
			return new ResponseEntity<>(lista, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/findByCpf")
	public ResponseEntity<List<Aluno>> findByCpf(@RequestParam String cpf){
		try {
			List<Aluno> lista = this.alunoService.findByCpf(cpf);
			return new ResponseEntity<>(lista, HttpStatus.OK);
		} catch (Exception e) {
			 e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
}
