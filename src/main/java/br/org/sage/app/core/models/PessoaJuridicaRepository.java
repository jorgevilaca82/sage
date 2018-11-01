package br.org.sage.app.core.models;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "pessoas-juridicas", itemResourceRel = "pessoasJuridicas")
public interface PessoaJuridicaRepository extends JpaRepository<PessoaJuridica, Long> {

}
