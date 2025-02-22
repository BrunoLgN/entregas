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

import app.entity.Professor;
import app.service.ProfessorService;

@RestController
@RequestMapping("api/professor")
public class ProfessorController {
	
	@Autowired
	private ProfessorService professorService;
	
	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody Professor professor){
		try {
			String mensagem = this.professorService.save(professor);
			return new ResponseEntity<>(mensagem, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<String> update(@RequestBody Professor professor, @PathVariable Long id){
		try {
			String mensagem = this.professorService.update(professor, id);
			return new ResponseEntity<>(mensagem, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

		}
	}
	
	@GetMapping("/findById/{id}")
	public ResponseEntity<Professor> findById(@PathVariable long id){
		try {
			Professor professor = this.professorService.findById(id);
			return new ResponseEntity<>(professor, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/findAll")
	public ResponseEntity<List<Professor>> findAll(){
		try {
			List<Professor> lista = this.professorService .findAll();
			return new ResponseEntity<>(lista, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable long id){
		try {
			
			String mensagem = this.professorService.delete(id);
			return new ResponseEntity<>(mensagem, HttpStatus.OK );
			
		} catch (Exception e) {
			
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST );

		}
	}
	
	@GetMapping("/findByNomeStartingWithOrEspecialidadeStartingWith")
	public ResponseEntity<List<Professor>> findByNomeStartingWithOrEspecialidadeStartingWith(@RequestParam String nome, String especialidade){
		try {
			List<Professor> lista = this.professorService.findByNomeStartingWithOrEspecialidadeStartingWith(nome, especialidade);
			return new ResponseEntity<>(lista, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/findByEmailNotContaining")
	public ResponseEntity<List<Professor>> findByEmailNotContaining(){
		try {
			List<Professor> lista = this.professorService.findByEmailNotContaining();
			return new ResponseEntity<>(lista, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/findByEmail")
	public ResponseEntity<List<Professor>> findByEmail(@RequestParam String email){
		try {
			List<Professor> lista = this.professorService.findByEmail(email);
			return new ResponseEntity<>(lista, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	

}
