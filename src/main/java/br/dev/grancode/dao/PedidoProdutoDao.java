package br.dev.grancode.dao;

import br.dev.grancode.modelo.PedidoProduto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PedidoProdutoDao {
    public static Connection getConnection(){
        Connection con=null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
//            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "laravel", "12345");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "leo", "root");
        }catch(Exception e){System.out.println(e);}
        return con;
    }
    public static int inserir(int produto_id, int quantidade) {
        int status = 0;
        PedidoProduto pedidoProduto =
        try {
            Connection con = PedidoProdutoDao.getConnection();

            // Preparar uma sentença SQL;
            PreparedStatement ps = con.prepareStatement(
                    "insert into Produtos_has_Pedidos (Produtos_ID, Pedidos_Numero," +
                                                " Quantidade, Preco_Unitario, Unidade) " +
                            "values (?, ?, ?, ?, ?)");

            // Parametrizar a senteça SQL;
            setFieldspedidoProduto(pedidoProduto, ps);

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

//    public static int atualizar(PedidoProduto pedidoProduto) {
//        int status = 0;
//
//        try {
//            Connection con= PedidoProdutoDao.getConnection();
//
//            // Preparar uma sentença SQL;
//            PreparedStatement ps = con.prepareStatement(
//                    "update Produtos_has_Pedidos set  Quantidade = ?, " +
//                            "Preco_Unitario = ?, Unidade = ?" +
//                            "WHERE Pedido_Numero = ? AND Produtos_ID = ?");
//
//            // Parametrizar a senteça SQL;
//            setFieldspedidoProduto(pedidoProduto, ps);
//            ps.setInt(4, pedidoProduto.getPedidoId());
//            ps.setInt(5, pedidoProduto.getProdutoId());
//
//            // Executar a Senteça;
//            status = ps.executeUpdate();
//
//            // Limpar a memória
//            ps.close();
//            con.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return status;
//    }


    private static void setProdutoPedido(PedidoProduto pedidoProduto) throws SQLException {
        int status=0;
        try{
            Connection con= PedidoProdutoDao.getConnection();
            PreparedStatement ps=con.prepareStatement("delete from Produtos_has_Pedidos where Produtos_ID = ? AND Pedidos_Numero = ?");
            ps.setInt(1, Produto_ID);
            ps.setInt(2, Pedido_Numero);

            status=ps.executeUpdate();

            con.close();
        }catch(Exception e){e.printStackTrace();}

        return status;
    }

    private static void setFieldspedidoProduto(PedidoProduto pedidoProduto, PreparedStatement ps) throws SQLException {
        ps.setInt(1, pedidoProduto.getProdutoId());
        ps.setInt(2, pedidoProduto.getPedidoId());
        ps.setInt(3, pedidoProduto.getQuantidade());
        ps.setFloat(4, pedidoProduto.getPreco());
        ps.setString(5, pedidoProduto.getUnidade());
    }

    public static int excluir(int Produto_ID, int Pedido_Numero) {
        int status=0;
        try{
            Connection con= PedidoProdutoDao.getConnection();
            PreparedStatement ps=con.prepareStatement("delete from Produtos_has_Pedidos where Produtos_ID = ? AND Pedidos_Numero = ?");
            ps.setInt(1, Produto_ID);
            ps.setInt(2, Pedido_Numero);

            status=ps.executeUpdate();

            con.close();
        }catch(Exception e){e.printStackTrace();}

        return status;
    }

    public static PedidoProduto getPedidoProdutoPorId(int id) {
        PedidoProduto pedidoProduto = new PedidoProduto();
        try{
            Connection con = PedidoProdutoDao.getConnection();
            PreparedStatement ps=con.prepareStatement("select * from from Produtos_has_Pedidos where Pedidos_Numero = ?");
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                //Get DataBase Fields to Cliente Object
                FieldsGet(rs, pedidoProduto);

            }
            con.close();
        }catch(Exception ex){ex.printStackTrace();}

        return pedidoProduto;
    }

//    public static List<PedidoProduto> getAllPedidoProdutos() {
//        List<PedidoProduto> list = new ArrayList<>();
//
//        try{
//            Connection con = PedidoProdutoDao.getConnection();
//            PreparedStatement ps=con.prepareStatement("select * from pedidoProdutos");
//            ResultSet rs = ps.executeQuery();
//
//            while (rs.next()){
//                PedidoProduto pedidoProduto = new PedidoProduto();
//
//                //Get DataBase Fields to Cliente Object
//                FieldsGet(rs, pedidoProduto);
//
//                list.add(pedidoProduto);
//            }
//            con.close();
//        }catch(Exception ex){ex.printStackTrace();}
//
//        return list;
//    }

    private static void FieldsGet(ResultSet rs, PedidoProduto pedidoProduto) throws SQLException {
        pedidoProduto.setProdutoId(rs.getInt(1));
        pedidoProduto.setPedidoId(Integer.parseInt(rs.getString(2)));
        pedidoProduto.setQuantidade(Integer.parseInt(rs.getString(3)));
        pedidoProduto.setPreco(Float.parseFloat(rs.getString(4)));
        pedidoProduto.setUnidade(rs.getString(5));
    }

}
