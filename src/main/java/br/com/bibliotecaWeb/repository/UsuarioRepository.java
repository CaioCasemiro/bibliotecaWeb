package br.com.bibliotecaWeb.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.bibliotecaWeb.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
    
    // Buscar usuário pelo e-mail (para autenticação, por exemplo)
    Optional<Usuario> findByEmail(String email);

    // Verificar se um e-mail já está cadastrado
    boolean existsByEmail(String email);
    
}
