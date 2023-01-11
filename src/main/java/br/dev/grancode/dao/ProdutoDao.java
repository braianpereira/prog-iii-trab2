package br.dev.grancode.dao;

import br.dev.grancode.modelo.Cliente;
import br.dev.grancode.modelo.Produto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDao {
    public static Connection getConnection(){
        Connection con=null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
//            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "laravel", "12345");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "leo", "root");
        }catch(Exception e){System.out.println(e);}
        return con;
    }
    public static int inserir(Produto produto) {
        int status = 0;

        try {
            Connection con = ProdutoDao.getConnection();

            // Preparar uma sentença SQL;
            PreparedStatement ps = con.prepareStatement(
                    "insert into Produtos (Nome, Descricao, Unidade, Preco_Unitario)" +
                            "values (?, ?, ?, ?)");

            // Parametrizar a senteça SQL;
            setFieldsProduto(produto, ps);

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

    public static int atualizar(Produto produto) {
        int status = 0;

        try {
            Connection con= ProdutoDao.getConnection();

            // Preparar uma sentença SQL;
            PreparedStatement ps = con.prepareStatement(
                    "update Produtos set Nome = ?, Descricao = ?, Unidade = ?, " +
                            "Preco_Unitario = ?" +
                            "WHERE ID = ?");

            // Parametrizar a senteça SQL;
            setFieldsProduto(produto, ps);
            ps.setInt(5, produto.getId());

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


    private static void setFieldsProduto(Produto produto, PreparedStatement ps) throws SQLException {
        ps.setString(1, produto.getNome());
        ps.setString(2, produto.getDescricao());
        ps.setString(3, produto.getUnidade());
        ps.setFloat(4, produto.getPreco_unitario());
    }

    public static int excluir(int id) {
        int status=0;
        try{
            Connection con= ProdutoDao.getConnection();
            PreparedStatement ps=con.prepareStatement("delete from Produtos where id = ?");
            ps.setInt(1, id);

            status=ps.executeUpdate();

            con.close();
        }catch(Exception e){e.printStackTrace();}

        return status;
    }

    public static Produto getProdutoPorId(int id) {
        Produto produto = new Produto();
        try{
            Connection con = ProdutoDao.getConnection();
            PreparedStatement ps=con.prepareStatement("select * from Produtos where id = ?");
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                //Get DataBase Fields to Cliente Object
                FieldsGet(rs, produto);

            }
            con.close();
        }catch(Exception ex){ex.printStackTrace();}

        return produto;
    }

    public static List<Produto> getAllProdutos() {
        List<Produto> list = new ArrayList<>();

        try{
            Connection con = ProdutoDao.getConnection();
            PreparedStatement ps=con.prepareStatement("select * from Produtos");
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                Produto produto = new Produto();

                //Get DataBase Fields to Cliente Object
                FieldsGet(rs, produto);

                list.add(produto);
            }
            con.close();
        }catch(Exception ex){ex.printStackTrace();}

        return list;
    }

    private static void FieldsGet(ResultSet rs, Produto produto) throws SQLException {
        produto.setId(rs.getInt(1));
        produto.setNome(rs.getString(2));
        produto.setDescricao(rs.getString(3));
        produto.setUnidade(rs.getString(4));
        produto.setPreco_unitario(rs.getFloat(5));
    }
}
