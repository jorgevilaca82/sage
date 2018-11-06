package br.org.sage.app.edu;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "unidadesDeEnsino", collectionResourceRel = "unidadesDeEnsino")
public interface UnidadeDeEnsinoRepository extends JpaRepository<UnidadeDeEnsino, Long> {

}