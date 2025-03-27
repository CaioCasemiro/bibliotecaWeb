package br.com.bibliotecaWeb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender emailSender;

    public void enviarEmailConfirmacaoEmprestimo(String emailUsuario, String nomeLivro, String dataDevolucao) {
        String mensagem = String.format(
            "Olá,\n\nO empréstimo do livro '%s' foi realizado com sucesso! A data de devolução é %s.\n\nAtenciosamente,\nBiblioteca",
            nomeLivro, dataDevolucao);
        
        enviarEmail(emailUsuario, "Confirmação de Empréstimo", mensagem);
    }

    public void enviarEmailAvisoDevolucao(String emailUsuario, String nomeLivro, String dataDevolucao) {
        String mensagem = String.format(
            "Olá,\n\nEste é um lembrete de que o livro '%s' tem data de devolução próxima (data limite: %s).\nPor favor, realize a devolução o mais rápido possível.\n\nAtenciosamente,\nBiblioteca",
            nomeLivro, dataDevolucao);
        
        enviarEmail(emailUsuario, "Aviso de Devolução de Empréstimo", mensagem);
    }

    private void enviarEmail(String para, String assunto, String mensagem) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("seuemail@gmail.com"); // Remetente
        message.setTo(para); // Destinatário
        message.setSubject(assunto);
        message.setText(mensagem);
        
        emailSender.send(message);
    }
}
