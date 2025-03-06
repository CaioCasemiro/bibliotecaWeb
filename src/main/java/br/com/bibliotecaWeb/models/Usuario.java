package br.com.bibliotecaWeb.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "usuarios")
public class Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_usuario")
    private Long idUsuario;

    @Column(unique = true)
    private String nome;

    private String email;
    private String telefone;
    private String senha;

    public List<Emprestimo> historicoReservas;
    public List<Livro> livrosReservados;
    
    
    public Usuario(String nome, String email, String telefone, String senha, List<Emprestimo> historicoReservas,
            List<Livro> livrosReservados) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.senha = senha;

        this.historicoReservas = historicoReservas != null ? historicoReservas : new ArrayList<>();
        this.livrosReservados = livrosReservados != null ? livrosReservados : new ArrayList<>();
        this.livrosReservados = livrosReservados;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
    public List<Emprestimo> getHistoricoReservas() {
        return historicoReservas;
    }
    public void setHistoricoReservas(List<Emprestimo> historicoReservas) {
        this.historicoReservas = historicoReservas;
    }
    public List<Livro> getLivrosReservados() {
        return livrosReservados;
    }
    public void setLivrosReservados(List<Livro> livrosReservados) {
        this.livrosReservados = livrosReservados;
    }


    
}
