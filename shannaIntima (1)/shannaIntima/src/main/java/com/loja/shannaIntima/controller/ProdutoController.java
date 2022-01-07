package com.loja.shannaIntima.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.loja.shannaIntima.model.Produto;
import com.loja.shannaIntima.repository.ProdutoRepository;

@RestController
@RequestMapping("/produtos")
@CrossOrigin (origins =  "*", allowedHeaders = "*")
public class ProdutoController {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	
	@GetMapping ("/{id}")
	public ResponseEntity<Produto> getById(@PathVariable long id){
		return produtoRepository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping
	public ResponseEntity <List<Produto>> getAll(){
		return ResponseEntity.ok(produtoRepository.findAll());
	}
	// LOCALIZAR POR NOME
	@GetMapping("/nome/{nome}")
	public ResponseEntity <List<Produto>> getByNome(@PathVariable String nome){
	return ResponseEntity.ok(produtoRepository.findAllByNomeContainingIgnoreCase(nome));
	}
	//LOCALIZAR POR PALAVRAS CHAVES 
	@GetMapping("/palavraChave/{palavraChave}")
	public ResponseEntity <List<Produto>> getByPalavraChave(@PathVariable String palavraChave){
	return ResponseEntity.ok(produtoRepository.findAllByPalavraChaveContainingIgnoreCase(palavraChave));
	}
	//CADASTRAR
    @PostMapping
    public ResponseEntity<Produto> post(@RequestBody Produto produto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoRepository.save(produto));
    }
    //ALTERAR POSTAGEM
    @PutMapping
    public ResponseEntity<Produto> put(@RequestBody Produto produto) {
        return produtoRepository.findById(produto.getId())
              .map(resp -> {
            return ResponseEntity.ok().body(produtoRepository.save(produto));
        })
        .orElse(ResponseEntity.notFound().build());
    }
    //DELETAR POSTAGEM
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduto(@PathVariable long id) {

        return produtoRepository.findById(id)
                .map(resposta -> {
                    produtoRepository.deleteById(id);
                    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
    
}   
