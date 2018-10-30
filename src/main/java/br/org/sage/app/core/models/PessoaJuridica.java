package br.org.sage.app.core.models;

import javax.persistence.Entity;

import br.org.sage.app.core.AbstractEntity;
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

	private final String nomeFantasia;
	private final String cnpj;

}