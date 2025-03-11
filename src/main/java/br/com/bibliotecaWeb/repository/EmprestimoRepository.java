package br.com.bibliotecaWeb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bibliotecaWeb.model.Emprestimo;
import br.com.bibliotecaWeb.model.Livro;
import br.com.bibliotecaWeb.model.Usuario;

import java.util.List;
import java.util.Optional;


public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long>{
    
    // Buscar empréstimos por usuário
    List<Emprestimo> findByUsuario(Usuario usuario);

    //Buscar empréstimos ativos de um livro específico
    Optional<Emprestimo> findByLivroAndDataDevolucaoRealIsNull(Livro livro);

    
}
