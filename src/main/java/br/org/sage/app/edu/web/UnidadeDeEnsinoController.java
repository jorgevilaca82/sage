package br.org.sage.app.edu.web;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.List;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CNPJ;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.org.sage.app.edu.UnidadeDeEnsino;
import br.org.sage.app.edu.UnidadeDeEnsinoRepository;

@RestController
@RequestMapping("unidades-de-ensino")
public class UnidadeDeEnsinoController {

	private final UnidadeDeEnsinoRepository unidadeDeEnsinoRepository;

	UnidadeDeEnsinoController(UnidadeDeEnsinoRepository unidadeDeEnsinoRepository) {
		this.unidadeDeEnsinoRepository = unidadeDeEnsinoRepository;
	}

	@GetMapping
	List<UnidadeDeEnsino> all() {
		return unidadeDeEnsinoRepository.findAll();
	}

	@PostMapping
	UnidadeDeEnsino saveNew(@RequestBody UnidadeDeEnsino newUnidadeDeEnsino) {
		return unidadeDeEnsinoRepository.save(newUnidadeDeEnsino);
	}

	@GetMapping("/{id}")
	Resource<UnidadeDeEnsino> one(@PathVariable Long id) {
		UnidadeDeEnsino unidadeDeEnsino = unidadeDeEnsinoRepository.findById(id)
				.orElseThrow(() -> new UnidadeDeEnsinoNotFoundException(id));

		return new Resource<>(unidadeDeEnsino, linkTo(methodOn(this.getClass()).one(id)).withSelfRel(),
				linkTo(methodOn(this.getClass()).all()).withRel("unidades-de-ensino"));
	}

}

class UnidadeDeEnsinoResource extends ResourceSupport {
}

@SuppressWarnings("serial")
class UnidadeDeEnsinoNotFoundException extends RuntimeException {
	UnidadeDeEnsinoNotFoundException(Long id) {
		super("Unidade de Ensino não encontrada: " + id);
	}
}

@ControllerAdvice
class UnidadeDeEnsinoNotFoundAdvice {

	@ResponseBody
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	@ExceptionHandler(UnidadeDeEnsinoNotFoundException.class)
	public String unidadeDeEnsinoNotFoundHandler(UnidadeDeEnsinoNotFoundException ex) {
		return ex.getMessage();
	}
}