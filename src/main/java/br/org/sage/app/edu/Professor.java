package br.org.sage.app.edu;

import javax.persistence.Entity;

import br.org.sage.app.core.models.PessoaFisica;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
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
public class Professor extends PessoaFisica {

	private boolean ativo;

	private Titulacao titulacao;

	public enum Titulacao {
		GRADUACAO, ESPECIALIZACAO, MESTRADO, DOUTORADO, POS_DOUTORADO;
	}

}
