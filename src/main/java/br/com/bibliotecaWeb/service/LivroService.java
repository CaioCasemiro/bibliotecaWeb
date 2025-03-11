package br.com.bibliotecaWeb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.bibliotecaWeb.model.Livro;
import br.com.bibliotecaWeb.repository.LivroRepository;

@Service
public class LivroService {

    private final LivroRepository livroRepository;

    public LivroService(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    //Listar todos os livros

    public List<Livro> listarTodos(){
        return livroRepository.findAll();
    }

    //Salvar um novo livro ou atualizar um livro existente
    public Livro salvar(Livro livro){
        return livroRepository.save(livro);
    }

    //Buscar um livro pelo ID
    public Optional<Livro> buscarPorId(Long id){
        return livroRepository.findById(id);
    }
    
    //Remoder um livro pelo ID
    public void removerPorId(Long id){
        livroRepository.deleteById(id);
    }
}
