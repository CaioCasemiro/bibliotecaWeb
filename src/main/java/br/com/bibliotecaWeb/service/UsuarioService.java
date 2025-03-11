package br.com.bibliotecaWeb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.bibliotecaWeb.model.Usuario;
import br.com.bibliotecaWeb.repository.UsuarioRepository;

@Service
public class UsuarioService {
    
    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    //Listar todos os usuários 
    public List<Usuario> listarUsuarios(){
        return usuarioRepository.findAll();
    }

    //Salvar um novo usuário ou atualizar um usuário existente
    public Usuario salvarUsuario(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    //Buscar um usuario por e-mail
    public Optional<Usuario> buscarPorEmail(String email){
        return usuarioRepository.findByEmail(email);
    }

    //Verifificar se um e-mail já está cadastrado
    public boolean emailExiste(String email){
        return usuarioRepository.existsByEmail(email);
    }

    //Buscar um usuário pelo ID
    public Optional<Usuario> buscarPorId(Long id){
        return usuarioRepository.findById(id);
    }
    
    
}
