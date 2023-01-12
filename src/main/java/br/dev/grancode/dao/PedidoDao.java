package br.dev.grancode.dao;

import br.dev.grancode.modelo.Pedido;
import br.dev.grancode.modelo.PedidoProduto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PedidoDao {
    public static Connection getConnection(){
        Connection con=null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
//            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "laravel", "12345");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "leo", "root");
        }catch(Exception e){System.out.println(e);}
        return con;
    }
    public static int inserir(Pedido pedido) {
        int status = 0;

        try {
            Connection con = PedidoDao.getConnection();

            // Preparar uma sentença SQL;
            PreparedStatement ps = con.prepareStatement(
                    "insert into Pedidos (Data_Emissao, Valor_Frete, Data_Entrega, Cliente_Id) " +
                            "values (?, ?, ?, ?)");

            // Parametrizar a senteça SQL;
            setFieldspedido(pedido, ps);

            // Executar a Senteça;
            status = ps.executeUpdate();

            for(int i = 0; i < pedido.getProduto().length; i++){
                setProdutoPedido(pedido.getProduto()[i],pedido.getQuantidae()[i]);
            }

            // Limpar a memória
            ps.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }

    private static void setProdutoPedido(String produto, String qtd) throws SQLException {
        int status=0;
        try{
            PedidoProduto pedidoProduto = new PedidoProduto();

            Connection con= PedidoDao.getConnection();
            PreparedStatement ps=con.prepareStatement("SELECT Unidade, Preco_Unitario from Produtos where ID = ?");
            PreparedStatement pd=con.prepareStatement("SELECT Numero FROM Pedidos ORDER BY Numero DESC LIMIT 1");



            status=ps.executeUpdate();

            con.close();
        }catch(Exception e){e.printStackTrace();}

        return status;
    }

    public static int atualizar(Pedido pedido) {
        int status = 0;

        try {
            Connection con= PedidoDao.getConnection();

            // Preparar uma sentença SQL;
            PreparedStatement ps = con.prepareStatement(
                    "update Pedidos set Data_Emissao = ?, Valor_Frete = ?, Data_Entrega = ?, " +
                            "Cliente_Id = ?" +
                            "WHERE Numero = ?");

            // Parametrizar a senteça SQL;
            setFieldspedido(pedido, ps);
            ps.setInt(5, pedido.getNumero());

            // Executar a Senteça;
            status = ps.executeUpdate();

            // Limpar a memória
            ps.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }


    private static void setFieldspedido(Pedido pedido, PreparedStatement ps) throws SQLException {
        ps.setString(1, pedido.getDataEmissao());
        ps.setFloat(2, pedido.getValorFrete());
        ps.setString(3, pedido.getDataEntrega());
        ps.setInt(4, pedido.getCliente());
    }

    public static int excluir(int id) {
        int status=0;
        try{
            Connection con= PedidoDao.getConnection();
            PreparedStatement ps=con.prepareStatement("delete from Pedidos where id = ?");
            ps.setInt(1, id);

            status=ps.executeUpdate();

            con.close();
        }catch(Exception e){e.printStackTrace();}

        return status;
    }

    public static Pedido getPedidoPorId(int id) {
        Pedido pedido = new Pedido();
        try{
            Connection con = PedidoDao.getConnection();
            PreparedStatement ps=con.prepareStatement("select * from Pedidos where id = ?");
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                //Get DataBase Fields to Cliente Object
                FieldsGet(rs, pedido);

            }
            con.close();
        }catch(Exception ex){ex.printStackTrace();}

        return pedido;
    }

    public static List<Pedido> getAllPedidos() {
        List<Pedido> list = new ArrayList<>();

        try{
            Connection con = PedidoDao.getConnection();
            PreparedStatement ps=con.prepareStatement("select * from Pedidos");
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                Pedido pedido = new Pedido();

                //Get DataBase Fields to Cliente Object
                FieldsGet(rs, pedido);

                list.add(pedido);
            }
            con.close();
        }catch(Exception ex){ex.printStackTrace();}

        return list;
    }

    private static void FieldsGet(ResultSet rs, Pedido pedido) throws SQLException {
        pedido.setNumero(rs.getInt(1));
        pedido.setDataEmissao(rs.getString(2));
        pedido.setValorFrete(Float.parseFloat(rs.getString(3)));
        pedido.setDataEntrega(rs.getString(4));
        pedido.setCliente(Integer.parseInt(rs.getString(5)));
    }
}
