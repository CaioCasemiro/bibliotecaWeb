package br.com.bibliotecaWeb.service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bibliotecaWeb.model.Emprestimo;
import br.com.bibliotecaWeb.model.Livro;
import br.com.bibliotecaWeb.model.Usuario;
import br.com.bibliotecaWeb.repository.EmprestimoRepository;
import br.com.bibliotecaWeb.repository.LivroRepository;

@Service
public class EmprestimoService {
    private final EmprestimoRepository emprestimoRepository;
    private final LivroRepository livroRepository;
    
    
    @Autowired
    private EmailService emailService;

    public EmprestimoService(EmprestimoRepository emprestimoRepository, LivroRepository livroRepository) {  
        this.emprestimoRepository = emprestimoRepository;
        this.livroRepository = livroRepository;
    }

    public Optional<Emprestimo> buscarPorId(Long idEmprestimo) {
        return emprestimoRepository.findById(idEmprestimo);
    }

    public List<Emprestimo> listarTodos() {
        return emprestimoRepository.findAll();
    }

    public Emprestimo salvar(Emprestimo emprestimo) {
        Emprestimo novoEmprestimo = emprestimoRepository.save(emprestimo);
        
        // Enviar o e-mail de confirmação de empréstimo
        emailService.enviarEmailConfirmacaoEmprestimo(
            novoEmprestimo.getUsuario().getEmail(),
            novoEmprestimo.getLivro().getTitulo(),
            novoEmprestimo.getDataDevolucaoPrevista().toString()
        );
        
        return novoEmprestimo;
    }

    public boolean deletar(Long idEmprestimo) {
        if (emprestimoRepository.existsById(idEmprestimo)) {
            emprestimoRepository.deleteById(idEmprestimo);
            return true;
        }
        return false;
    }

    // Método para realizar o empréstimo
    public Emprestimo realizaEmprestimo(Usuario usuario, Livro livro, LocalDate dataDevolucaoPrevista){
        if (usuario == null || livro == null) {
            throw new RuntimeException("Usuário ou Livro não podem ser nulos");
        }
        
        if (!livro.getDisponivel()) {
            throw new RuntimeException("Livro indisponível");
        }
    
        Emprestimo emprestimo = new Emprestimo(); 
        emprestimo.setUsuario(usuario);
        emprestimo.setLivro(livro);
        emprestimo.setDataEmprestimo(LocalDate.now());
        emprestimo.setDataDevolucaoPrevista(dataDevolucaoPrevista);
        emprestimo.setMultas(0.0);
    
        livro.setDisponivel(false);
        livroRepository.save(livro);
        return emprestimoRepository.save(emprestimo);
    }
    

    // Método para devolver o empréstimo
    public Emprestimo devolverEmprestimo(Long idEmprestimo){
        Emprestimo emprestimo = emprestimoRepository.findById(idEmprestimo).orElseThrow(() -> new RuntimeException("Empréstimo não encontrado"));

        LocalDate dataDevolucaoReal = LocalDate.now();
        emprestimo.setDataDevolucaoReal(dataDevolucaoReal);

        if(emprestimo.getDataDevolucaoPrevista() != null && dataDevolucaoReal.isAfter(emprestimo.getDataDevolucaoPrevista())){
            long diasAtraso = ChronoUnit.DAYS.between(emprestimo.getDataDevolucaoPrevista(), dataDevolucaoReal);
            double multa = diasAtraso * 2.0; // R$2 por dia de atraso
            emprestimo.setMultas(multa);
        }

        Livro livro = emprestimo.getLivro();
        livro.setDisponivel(true);
        livroRepository.save(livro);
        return emprestimoRepository.save(emprestimo);
    }

    // Listar empréstimos por usuário
    public List<Emprestimo> listarEmprestimosPorUsuario(Usuario usuario){
        return emprestimoRepository.findByUsuario(usuario);
    }
}
