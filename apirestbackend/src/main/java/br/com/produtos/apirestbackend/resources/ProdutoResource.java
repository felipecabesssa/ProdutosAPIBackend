package br.com.produtos.apirestbackend.resources;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.produtos.apirestbackend.models.Produto;
import br.com.produtos.apirestbackend.repositories.ProdutoRepository;

@RestController
@CrossOrigin
@RequestMapping(value="/api")
public class ProdutoResource {

	@Autowired
	ProdutoRepository produtoRepository;
	
	@GetMapping("/produtos")
	public List<Produto> listaProdutos(){
		return produtoRepository.findAll();
	}
	
	@GetMapping("/produto/{id}")
	public Produto listaProdutoUnico(@PathVariable(value="id") long id){
		return produtoRepository.findById(id);
	}
	
//                               RequestBody pq vai receber o produto no corpo da requisição.	
	@PostMapping("/produto")
	public Produto salvaProduto(@RequestBody Produto produto) {
		return produtoRepository.save(produto);
	}
	
	@DeleteMapping("/produto/{id}")
	@Transactional
	public void deletaProduto(@PathVariable(value="id") Produto id) {
		produtoRepository.delete(id);
	}
	
	@PutMapping("/produto/{id}")
	public Produto atualizaProduto(@PathVariable(value="id") long id, @RequestBody Produto produto) {
		return produtoRepository.save(produto);
	}
	
}
