package br.dev.grancode.modelo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Pessoa {

    private String cpf;
    private String nome;
    private String nascimento;
    private String email;
    private String telefone;
    private boolean whats;

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

    public String getNascimento() {
        return nascimento;
    }

    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
    }

    public  String getNascimentoBr() throws ParseException {
        return dataString(this.nascimento);
    }

    public String dataString(String datas) throws ParseException {
        SimpleDateFormat formaOring = new SimpleDateFormat("yyyy-MM-dd");
        Date data = formaOring.parse(datas);

        SimpleDateFormat formatDest = new SimpleDateFormat("dd/MM/yyyy");
        String dataString = formatDest.format(data);
        return dataString;
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


}
