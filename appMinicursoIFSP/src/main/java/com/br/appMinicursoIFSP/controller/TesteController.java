package com.br.appMinicursoIFSP.controller;

import java.sql.SQLException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.br.appMinicursoIFSP.dao.ProdutoDao;
import com.br.appMinicursoIFSP.model.Produto;

@RestController
@RequestMapping("/api-teste")
public class TesteController {
	
	
	@RequestMapping(value = "/produto/{id}", method = RequestMethod.GET)
	public ResponseEntity<Produto> buscaProduto(@PathVariable("id") int codigo) {
	
 		
		
		Produto p = new Produto();
		p.setCodigo( 1 );
		p.setDescricao("Produto Teste");
		
		return ResponseEntity.status(HttpStatus.OK).body(p);
	}
	
	@RequestMapping(value = "/produto/", method =  RequestMethod.POST)
    public ResponseEntity<Produto> Insere( @RequestBody Produto p)
    {
		try {
			new ProdutoDao().insereProduto(p);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		return ResponseEntity.status(HttpStatus.OK).body(p);
    }		
}
