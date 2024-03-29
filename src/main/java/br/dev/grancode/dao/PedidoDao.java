package br.dev.grancode.dao;

import br.dev.grancode.modelo.Pedido;
import br.dev.grancode.modelo.PedidoProduto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PedidoDao extends Dao{
    public static int inserir(Pedido pedido) {
        int status = 0;

        try {
            Connection con = PedidoDao.getConnection();

            // Preparar uma sentença SQL;
            PreparedStatement ps = con.prepareStatement(
                    "insert into Pedidos (Data_Emissao, Valor_Frete, Data_Entrega, Clientes_ID) " +
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
        try{
            PedidoProduto pedidoProduto = new PedidoProduto();

            Connection con= PedidoDao.getConnection();

            try {

                PreparedStatement ps=con.prepareStatement("SELECT Unidade, Preco_Unitario from Produtos where ID = ?;");
                ps.setInt(1, Integer.parseInt(produto));
                ResultSet rs = ps.executeQuery();

                if(rs.next()) {
                    pedidoProduto.setUnidade(rs.getString(1));
                    pedidoProduto.setPreco(rs.getFloat(2));
                }
                ps.close();
                rs.close();

            }catch (SQLException e) { e.printStackTrace(); }
            catch(Exception e){e.printStackTrace();}

            try {

                PreparedStatement pd=con.prepareStatement("SELECT Numero FROM Pedidos ORDER BY Numero DESC LIMIT 1;");
                ResultSet rd = pd.executeQuery();
                if(rd.next()) {
                    pedidoProduto.setPedidoId(rd.getInt(1));
                }

                pedidoProduto.setProdutoId(Integer.parseInt(produto));
                pedidoProduto.setQuantidade(Integer.parseInt(qtd));

                pd.close();
                rd.close();
            }catch (SQLException e) { e.printStackTrace(); }
            catch(Exception e){e.printStackTrace();}

            PedidoProdutoDao.inserir(pedidoProduto, con);

            con.close();
        }catch (SQLException e) { e.printStackTrace(); }
        catch(Exception e){e.printStackTrace();}

    }

    public static int atualizar(Pedido pedido) {
        int status = 0;

        try {
            Connection con= PedidoDao.getConnection();

            // Preparar uma sentença SQL;
            PreparedStatement ps = con.prepareStatement(
                    "update Pedidos set Data_Emissao = ?, Valor_Frete = ?, Data_Entrega = ?, Clientes_ID = ? WHERE Numero = ?");

            // Parametrizar a senteça SQL;
            setFieldspedido(pedido, ps);
            ps.setInt(5, pedido.getNumero());

            // Executar a Senteça;
            status = ps.executeUpdate();

            ps = con.prepareStatement("DELETE FROM Produtos_has_Pedidos where Pedidos_Numero = ?;");
            ps.setInt(1, pedido.getNumero());
            status = ps.executeUpdate();


            for(int i = 0; i < pedido.getProduto().length; i++){
                updateProdutoPedido(pedido.getProduto()[i], pedido.getQuantidae()[i], pedido.getNumero());
            }


            // Limpar a memória
            ps.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return status;
    }

    private static void updateProdutoPedido(String produto, String qtd, int numeroPedido) throws SQLException {
        try{
            PedidoProduto pedidoProduto = new PedidoProduto();

            Connection con= PedidoDao.getConnection();

            try {
//                con.setAutoCommit(false);

                PreparedStatement ps = con.prepareStatement("SELECT Unidade, Preco_Unitario from Produtos where ID = ?;");
                ps.setInt(1, Integer.parseInt(produto));
                ResultSet rs = ps.executeQuery();

                if(rs.next()) {
                    pedidoProduto.setUnidade(rs.getString(1));
                    pedidoProduto.setPreco(rs.getFloat(2));
                }

                ps.close();
                rs.close();


                pedidoProduto.setPedidoId(numeroPedido);


                pedidoProduto.setProdutoId(Integer.parseInt(produto));
                pedidoProduto.setQuantidade(Integer.parseInt(qtd));

                PedidoProdutoDao.inserir(pedidoProduto, con);

//                con.commit();
            }catch (SQLException e) {
                e.printStackTrace();
//                con.rollback();
            }
            catch(Exception e){e.printStackTrace();}
            finally {

                con.close();
            }


        }catch (SQLException e) { e.printStackTrace(); }
        catch(Exception e){e.printStackTrace();}

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

            PreparedStatement ps = con.prepareStatement("delete from Produtos_has_Pedidos where Pedidos_Numero = ?");
            ps.setInt(1, id);

            status=ps.executeUpdate();

            ps = con.prepareStatement("delete from Pedidos where Numero = ?");
            ps.setInt(1, id);

            status=ps.executeUpdate();

            con.close();
        }catch(Exception e){e.printStackTrace();}

        return status;
    }

    public static Pedido getPedidoPorNumero(int numero) {
        Pedido pedido = new Pedido();
        try{
            Connection con = PedidoDao.getConnection();
            PreparedStatement ps=con.prepareStatement("select * from Pedidos where Numero = ?");
            ps.setInt(1, numero);

            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                //Get DataBase Fields to Cliente Object
                FieldsGet(rs, pedido);

                pedido.setPedidoProduto(PedidoProdutoDao.getAllPedidoProdutosPorId(rs.getInt("Numero")));

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

                pedido.setPedidoProduto(PedidoProdutoDao.getAllPedidoProdutosPorId(pedido.getNumero()));

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
