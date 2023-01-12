package br.dev.grancode.modelo;

import br.dev.grancode.dao.ClienteDao;

import java.text.NumberFormat;
import java.util.Locale;

public class Pedido {

    int numero;

    String dataEmissao;

    float valorFrete;

    String dataEntrega;

    int cliente;

    Cliente clienteM;

    String[] produto;

    String[] quantidae;
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
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

    public String getFreteString(){
        Locale ptBr = new Locale("pt", "BR");
        String valorString = NumberFormat.getCurrencyInstance(ptBr).format(valorFrete);
        return valorString;
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

    public Cliente getClienteM() {
        clienteM = ClienteDao.getClientePorId(getCliente());

        return clienteM;
    }

    public void setCliente(int cliente) {
        this.cliente = cliente;
    }

    public String[] getProduto() {
        return produto;
    }

    public void setProduto(String[] produto) {
        this.produto = produto;
    }

    public String[] getQuantidae() {
        return quantidae;
    }

    public void setQuantidae(String[] quantidae) {
        this.quantidae = quantidae;
    }
}
