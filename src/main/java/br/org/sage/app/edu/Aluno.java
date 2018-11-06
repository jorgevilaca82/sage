package br.org.sage.app.edu;

import javax.persistence.Entity;

import br.org.sage.app.core.models.PessoaFisica;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * Unidades de Ensino
 * 
 * @author 2199485
 *
 */
@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
public class Aluno extends PessoaFisica {

	private String ra;
	
	private Status status;

	public static enum Status {
		MATRICULADO;
	}

}
