package br.com.produtos.apirestbackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.produtos.apirestbackend.models.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	
	Produto findById(long id);


}
