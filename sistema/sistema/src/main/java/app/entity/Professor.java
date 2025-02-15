package app.entity;

import java.util.List;

import org.hibernate.validator.constraints.br.CPF;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Professor {
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "professor_turma")
	private List<Turma> turmas;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Pattern(regexp = "^(\\S+\\s+\\S+.*)$")
	private String nome;
	
	@CPF
	private String cpf;
	
	@Email
	private String email;
	
	@Pattern(regexp = "^(\\S+\\s+\\S+.*)$")
	@Null
	private String especialidade;
	
}
