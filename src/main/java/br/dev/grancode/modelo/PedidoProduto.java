package br.dev.grancode.modelo;

import br.dev.grancode.dao.ProdutoDao;

public class PedidoProduto {

    private int pedidoId;

    private int produtoId;

    private int quantidade;

    private float preco;

    private String unidade;

    private Produto produto;

    public int getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(int pedidoId) {
        this.pedidoId = pedidoId;
    }

    public int getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(int produtoId) {
        this.produtoId = produtoId;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public String nomeProd(){
        produto = ProdutoDao.getProdutoPorId(produtoId);

        return produto.getNome();
    }

}
