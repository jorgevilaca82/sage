package br.org.sage.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import br.org.sage.app.edu.UnidadeDeEnsino;

@SpringBootApplication
public class SageApplication {

	public static void main(String[] args) {
		SpringApplication.run(SageApplication.class, args);
	}
	
	@Bean
	Validator beforeCreateUnidadeDeEnsinoValidator() {
		return new Validator() {
			
			@Override
			public void validate(Object target, Errors errors) {
				ValidationUtils.rejectIfEmpty(errors, "tipo", "ue.tipo.empty");				
			}
			
			@Override
			public boolean supports(Class<?> clazz) {
				return clazz.equals(UnidadeDeEnsino.class);
			}
		};

	}
}