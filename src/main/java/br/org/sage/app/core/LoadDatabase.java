package br.org.sage.app.core;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.org.sage.app.edu.UnidadeDeEnsinoRepository;
import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
class LoadDatabase {
	//https://spring.io/guides/tutorials/rest/
	//https://spring.io/blog/2011/02/10/getting-started-with-spring-data-jpa/
	
	@Bean
	CommandLineRunner initDatabase(UnidadeDeEnsinoRepository repository) {
		return args -> {
//			log.info("Preloading " + repository.save(new UnidadeDeEnsino()));
//			log.info("Preloading " + repository.save(new UnidadeDeEnsino()));
		};
	}
}