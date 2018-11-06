package br.org.sage.app.core.models;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.util.StringUtils;

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
public class PessoaFisica extends AbstractAuditEntity {

	@NotBlank
	@Length(min = 2, max = 255)
	private final String nomeCompleto;

	@NotBlank
	@CPF
	private final String cpf;
	
	@Email
	private final String email;
	
	private boolean falecido;
	
	private PessoaFisica mae;
	
	private PessoaFisica pai;

	public enum EstadoCivil {
		SOLTEIRO, CASADO, UNIAO_ESTAVEL("União Estável"), DIVORCIADO, VIUVO("Viúvo");

		private String descricao = new String();

		public String getDescricao() {
			if (descricao.isEmpty()) {
				return StringUtils.capitalize(name().toLowerCase());
			} else {
				return descricao;
			}
		}

		@Override
		public String toString() {
			return getDescricao();
		}

		EstadoCivil(String descricao) {
			this.descricao = descricao;
		}

		EstadoCivil() {
		}
	}

	public enum TipoSanguineo {
		OP("O+"), ON("O-"), AP("A+"), AN("A-"), BP("B+"), BN("B-"), ABP("AB+"), ABN("AB-");

		private String descricao = new String();

		@Override
		public String toString() {
			return descricao;
		}

		private TipoSanguineo(String descricao) {
			this.descricao = descricao;
		}
	}

	public enum Nacionalidade {
		BRASILEIRA, BRASILEIRO_NASCIDO_EXTERIOR, ESTRANGEIRA
	}

	public enum NecessidadeEspecial {
		BAIXA_VISÃO, CEGUEIRA, DEFICIÊNCIA_AUDITIVA, DEFICIÊNCIA_FÍSICA, DEFICIÊNCIA_INTELECTUAL, DEFICIÊNCIA_MÚLTIPLA,
		SURDEZ, SURDOCEGUEIRA;
	}
}