package com.othiagoduarte.cursomc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.othiagoduarte.cursomc.domain.Categoria;
import com.othiagoduarte.cursomc.domain.Produto;
import com.othiagoduarte.cursomc.repositories.CategoriaRepository;
import com.othiagoduarte.cursomc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}
	
	@Autowired
	private CategoriaRepository repoCategoria;

	@Autowired
	private ProdutoRepository repoProduto;
	
	@Override
	public void run(String... args) throws Exception {
		Categoria c1 = new Categoria(1, "Eletro domestico");
		Categoria c2 = new Categoria(2, "Informatica");
		Categoria c3 = new Categoria(3, "Ferragem");
		Categoria c4 = new Categoria(4, "Encanamento");
		Categoria c5 = new Categoria(5, "Pintura")	;				

		Produto p1 = new Produto(null, "Mouse", 15.00);
		Produto p2 = new Produto(null, "Teclado", 15.00);
		Produto p3 = new Produto(null, "WebCan", 15.00);

		c2.getProdutos().addAll(List.of(p1, p2, p3));
		p1.getCategorias().add(c2);
		p2.getCategorias().add(c2);
		p3.getCategorias().add(c2);
		
		repoProduto.saveAll(List.of(p1, p2, p3));
		repoCategoria.saveAll(List.of(c1, c2, c3, c4, c5));
	}
}
