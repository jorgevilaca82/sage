package br.org.sage.app.core.models;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CNPJ;

import br.org.sage.app.core.AbstractAuditEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor(force = true)
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Inheritance(strategy = InheritanceType.JOINED)
public class PessoaJuridica extends AbstractAuditEntity {

	@NotBlank
	@Length(min = 2, max = 255)
	private final String nomeFantasia;

	@NotBlank
	@CNPJ
	private final String cnpj;

}