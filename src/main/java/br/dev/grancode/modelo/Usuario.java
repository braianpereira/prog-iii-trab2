package br.dev.grancode.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Calendar;

public class Usuario {
    private String cpf;
    private String nome;
    private Calendar nascimento;
    private String email;
    private String telefone;
    private boolean whats;
    private String username;
    private String senha;

    public void inserir() {
        try {
            /* Aqui vai o algoritmo de persistência */
            // Abrir uma conexão com o database;
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "laravel", "12345");

            // Preparar uma sentença SQL;
            PreparedStatement ps = con.prepareStatement(
                    "insert into usuarios (CPF, Nome, Data_Nascimento, Email, Telefone, Whats, Username, Senha) " +
                            "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

            // Parametrizar a senteça SQL;
            ps.setString(1, this.getCpf());
            ps.setString(2, this.getNome());
            ps.setDate(3, java.sql.Date.valueOf(this.getNascimento().toString()));
            ps.setString(4, this.getEmail());
            ps.setString(5, this.getTelefone());
            ps.setBoolean(6, this.isWhats());
            ps.setString(7, this.getUsername());
            ps.setString(8, this.getSenha());

            // Executar a Senteça;
            ps.execute();

            // Limpar a memória
            ps.close();
            con.close();
        } catch (Exception e) {
            ;
        }
    }

    public void atualizar() {

    }

    public void excluir() {

    }

    public void consultar() {

    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Calendar getNascimento() {
        return nascimento;
    }

    public void setNascimento(Calendar nascimento) {
        this.nascimento = nascimento;
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

    public boolean isWhats() {
        return whats;
    }

    public void setWhats(boolean whats) {
        this.whats = whats;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
