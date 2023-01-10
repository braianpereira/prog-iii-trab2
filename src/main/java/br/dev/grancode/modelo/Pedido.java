package br.dev.grancode.modelo;

import java.sql.Date;

public class Pedido {

    int mumero;

    String dataEmissao;

    float valorFrete;

    String dataEntrega;

    int cliente;

    public int getMumero() {
        return mumero;
    }

    public void setMumero(int mumero) {
        this.mumero = mumero;
    }

    public String getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(String dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    public float getValorFrete() {
        return valorFrete;
    }

    public void setValorFrete(float valorFrete) {
        this.valorFrete = valorFrete;
    }

    public String getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(String dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public int getCliente() {
        return cliente;
    }

    public void setCliente(int cliente) {
        this.cliente = cliente;
    }
}
