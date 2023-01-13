package br.dev.grancode.modelo;

import br.dev.grancode.dao.ClienteDao;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

public class Pedido {

    private int numero;

    private String dataEmissao;

    private float valorFrete;

    private  String dataEntrega;

    private int cliente;

    private Cliente clienteM;

    private String[] produto;

    private String[] quantidae;
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getDataEmissao() {
        return dataEmissao;
    }

    public  String getDataEmissaoPt() throws ParseException {
        return dataString(this.dataEmissao);
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

    public  String getDataEntregaPt() throws ParseException {
        return dataString(this.dataEntrega);
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

    public String dataString(String datas) throws ParseException {
        SimpleDateFormat formaOring = new SimpleDateFormat("yyyy-MM-dd");
        Date data = formaOring.parse(datas);
        System.out.println(data);

        SimpleDateFormat formatDest = new SimpleDateFormat("dd/MM/yyyy");
        String dataString = formatDest.format(data);
        return dataString;
    }

    public String getDataAtual(){
        SimpleDateFormat formatDest = new SimpleDateFormat("yyyy-MM-dd");
        String dataString = formatDest.format(LocalDate.now());

        return dataString;
    }
}
