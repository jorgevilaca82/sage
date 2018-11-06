package br.org.sage.app.edu;

import org.springframework.data.jpa.repository.JpaRepository;

//@RepositoryRestResource(path = "unidades-de-ensino", collectionResourceRel = "unidadesDeEnsino", excerptProjection = UnidadeDeEnsinoPJ.class)
public interface UnidadeDeEnsinoRepository extends JpaRepository<UnidadeDeEnsino, Long> {

}