package br.org.sage.app.core.models;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CNPJ;

import br.org.sage.app.core.AbstractEntity;
import br.org.sage.app.edu.UnidadeDeEnsino;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor(force = true)
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class PessoaJuridica extends AbstractEntity {

	@NotBlank
	@Length(min = 2, max = 255)
	private final String nomeFantasia;

	@NotBlank
	@CNPJ
	private final String cnpj;
	
	@OneToOne(mappedBy = "pessoaJuridica")
	private UnidadeDeEnsino unidadeDeEnsino;

}