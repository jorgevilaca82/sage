package br.org.sage.app.core;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.org.sage.app.core.models.PessoaJuridica;
import br.org.sage.app.edu.UnidadeDeEnsino;
import br.org.sage.app.edu.UnidadeDeEnsinoRepository;
import lombok.extern.slf4j.Slf4j;

import br.org.sage.app.edu.UnidadeDeEnsino.Tipo;

@Configuration
@Slf4j
class LoadDatabase {
	//https://spring.io/guides/tutorials/rest/
	//https://spring.io/blog/2011/02/10/getting-started-with-spring-data-jpa/
	
	@Bean
	CommandLineRunner initDatabase(UnidadeDeEnsinoRepository repository) {
		return args -> {
			repository.deleteAll();
			PessoaJuridica pessoaJuridica = new PessoaJuridica("Instituto Federal", "77.718.351/0001-67", null);
			log.info("Preloading " + repository.save(new UnidadeDeEnsino(Tipo.INSTITUTO, pessoaJuridica, null, null)));
//			log.info("Preloading " + repository.save(new UnidadeDeEnsino()));
		};
	}
}