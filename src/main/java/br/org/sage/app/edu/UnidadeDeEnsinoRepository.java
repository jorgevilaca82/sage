package br.org.sage.app.edu;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UnidadeDeEnsinoRepository extends JpaRepository<UnidadeDeEnsino, Long> {

}