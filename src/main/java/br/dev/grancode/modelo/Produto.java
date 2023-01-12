package br.dev.grancode.modelo;

import java.text.NumberFormat;
import java.util.Locale;

public class Produto {

    int id;

    String nome;

    String descricao;

    String unidade;

    float preco_unitario;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public float getPreco_unitario() {
        return preco_unitario;
    }

    public String getPrecoBr() {
        Locale ptBr = new Locale("pt", "BR");
        String valorString = NumberFormat.getCurrencyInstance(ptBr).format(preco_unitario);
        return valorString;
    }

    public void setPreco_unitario(float preco_unitario) {
        this.preco_unitario = preco_unitario;
    }


}
