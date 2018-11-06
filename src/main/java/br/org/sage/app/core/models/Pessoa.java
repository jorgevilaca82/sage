package br.org.sage.app.core.models;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
class Endereco {
	private String cep;
	private String logradouro;
	private String numero;
	private String bairro;
	private String complemento;
}

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
class Telefone {
	private Tipo tipo;
	private String numero;
	
	public enum Tipo {
		CELULAR, FIXO_COMERCIAL, FIXO_RESIDENCIAL;
	}
}

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
class ContatoSocial {
	private Tipo tipo;
	private String contato;
	
	public enum Tipo {
		EMAIL, FACEBOOK, TWITTER, INSTAGRAM, SKYPE, LINKEDIN;
	}
}

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pessoa {
	
	@OneToMany
	private Set<ContatoSocial> contatosSociais;
	
	@OneToMany
	private Set<Endereco> enderecos;
	
	@OneToMany
	private Set<Telefone> telefones;
}
