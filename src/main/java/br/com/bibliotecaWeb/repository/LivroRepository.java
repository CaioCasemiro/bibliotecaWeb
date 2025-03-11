package br.com.bibliotecaWeb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.bibliotecaWeb.model.Livro;

@Repository
public interface LivroRepository   extends JpaRepository<Livro, Long>{
     // Buscar livros pelo título
     List<Livro> findByTituloContainingIgnoreCase(String titulo);

     // Buscar livros por disponibilidade
     List<Livro> findByDisponivelTrue();
}