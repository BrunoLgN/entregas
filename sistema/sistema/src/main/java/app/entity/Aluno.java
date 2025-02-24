package app.entity;

import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Aluno {
	
	@ManyToOne()
	@JsonIgnoreProperties("alunos")
	private Turma turma;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Pattern(regexp = "^[\\S]+(\\s+[\\S]+)*$", message = "O nome deve conter pelo menos duas palavras.")
	@NotBlank
	private String nome;

	
	@CPF
	@NotBlank
	private String cpf;
	
	private String telefone;
	
	private Boolean cadastroCompleto;
	
	
}
