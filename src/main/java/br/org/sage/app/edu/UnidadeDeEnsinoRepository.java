package br.org.sage.app.edu;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "uepj", types = UnidadeDeEnsino.class)
interface UnidadeDeEnsinoPJ {
	String getTipo();

	@Value("#{target.pessoaJuridica?.cnpj}")
	String getCnpj();

	@Value("#{target.pessoaJuridica?.nomeFantasia}")
	String getNomeFantasia();
}

@RepositoryRestResource(path = "unidades-de-ensino", collectionResourceRel = "unidadesDeEnsino", excerptProjection = UnidadeDeEnsinoPJ.class)
public interface UnidadeDeEnsinoRepository extends JpaRepository<UnidadeDeEnsino, Long> {

}