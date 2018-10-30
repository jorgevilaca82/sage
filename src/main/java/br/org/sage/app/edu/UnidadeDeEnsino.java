package br.org.sage.app.edu;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import br.org.sage.app.core.AbstractEntity;
import br.org.sage.app.core.models.PessoaJuridica;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Unidades de Ensino
 * 
 * @author 2199485
 *
 */
@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class UnidadeDeEnsino extends AbstractEntity {

	/**
	 * Tipo da unidade de ensino, defindo a partir de enum interno à classe
	 */
	@Enumerated(EnumType.ORDINAL)
	private Tipo tipo;

	/**
	 * Representa a PJ associada à unidade
	 */
	@OneToOne(optional = false, cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
	private PessoaJuridica pessoaJuridica;

	/**
	 * Representa a Unidade ao qual esta é subordinada
	 */
	@ManyToOne(optional = false)
	@JoinColumn(name = "unidade_superior_id", nullable = false, updatable = false)
	private UnidadeDeEnsino unidadeSuperior;

	/**
	 * Lista de unidades subordinadas a esta
	 */
	@OneToMany
	private Set<UnidadeDeEnsino> unidadesSubordinadas;

	/**
	 * Tipos de Unidade de Ensino.
	 * 
	 * CUIDADO: Mantenha a ordem de declaração dos tipos. Se preciso acrescente
	 * novos tipos ao final.
	 * 
	 * @author 2199485
	 *
	 */
	public static enum Tipo {
		INSTITUTO, UNIVERSIDADE, FACULDADE, POLO, ESCOLA;
	}

}
