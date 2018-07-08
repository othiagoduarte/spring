package com.othiagoduarte.cursomc.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.othiagoduarte.cursomc.domain.Categoria;
import com.othiagoduarte.cursomc.services.CategoriaService;

@RestController
@RequestMapping(value="v1/categorias")
public class CategoriaResource {
	
	@Autowired
	private CategoriaService service;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<?> findAll(){
		List<Categoria> categorias = service.findAll();
		return categorias != null && categorias.size() > 0 ? ResponseEntity.ok().body(categorias) : ResponseEntity.notFound().build();		
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> findById(@PathVariable Integer id) {
		Categoria categoria = service.find(id);
		return categoria != null ? ResponseEntity.ok().body(categoria) : ResponseEntity.notFound().build();
	}
}
