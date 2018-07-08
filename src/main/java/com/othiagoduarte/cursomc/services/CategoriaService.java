package com.othiagoduarte.cursomc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.othiagoduarte.cursomc.domain.Categoria;
import com.othiagoduarte.cursomc.repositories.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repo;
	
	public Categoria find(Integer id) {
		return repo.findById(id).orElse(null);
	}
}
