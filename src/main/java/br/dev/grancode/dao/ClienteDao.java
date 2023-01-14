package br.dev.grancode.dao;

import br.dev.grancode.modelo.Cliente;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDao extends Dao{
    public static int inserir(Cliente cliente) {
        int status = 0;

        try {
            Connection con = ClienteDao.getConnection();

            // Preparar uma sentença SQL;
            PreparedStatement ps = con.prepareStatement(
                "insert into Clientes (Nome, Data_Nascimento, CPF, RG, Orgao_Emissor, Email, Telefone, Whats, Logradouro, Numero, Bairro, Cidade, Estado) " +
                            "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

            // Parametrizar a senteça SQL;
            setFieldsClient(cliente, ps);

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

    public static int atualizar(Cliente cliente) {
        int status = 0;

        try {
            Connection con= ClienteDao.getConnection();

            // Preparar uma sentença SQL;
            PreparedStatement ps = con.prepareStatement(
            "update Clientes set Nome = ?, Data_Nascimento = ?, CPF = ?, " +
                    "RG = ?, Orgao_Emissor = ?, Email = ?, " +
                    "Telefone = ?, Whats = ?, Logradouro = ?, " +
                    "Numero = ?, Bairro = ?, Cidade = ?, Estado = ?" +
                            "WHERE ID = ?");

            // Parametrizar a senteça SQL;
            setFieldsClient(cliente, ps);
            ps.setInt(14, cliente.getId());

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

    private static void setFieldsClient(Cliente cliente, PreparedStatement ps) throws SQLException {
        ps.setString(1, cliente.getNome());
        ps.setString(2, cliente.getNascimento());
        ps.setString(3, cliente.getCpf());
        ps.setString(4, cliente.getRg());
        ps.setString(5, cliente.getOrgao_emissor());
        ps.setString(6, cliente.getEmail());
        ps.setString(7, cliente.getTelefone());
        ps.setBoolean(8, cliente.isWhats());
        ps.setString(9, cliente.getLogradouro());
        ps.setString(10, cliente.getNumero());
        ps.setString(11, cliente.getBairro());
        ps.setString(12, cliente.getCidade());
        ps.setString(13, cliente.getEstado());
    }

    public static int excluir(int id) {
        int status=0;
        try{
            Connection con= ClienteDao.getConnection();
            PreparedStatement ps=con.prepareStatement("delete from Clientes where id = ?");
            ps.setInt(1, id);

            status=ps.executeUpdate();

            con.close();
        }catch(Exception e){e.printStackTrace();}

        return status;
    }

    public static Cliente getClientePorId(int id) {
        Cliente cliente = new Cliente();
        try{
            Connection con = ClienteDao.getConnection();
            PreparedStatement ps=con.prepareStatement("select * from Clientes where id = ?");
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                //Get DataBase Fields to Cliente Object
                FieldsGet(rs, cliente);

            }
            con.close();
        }catch(Exception ex){ex.printStackTrace();}

        return cliente;
    }

    public static List<Cliente> getAllClientes() {
        List<Cliente> list = new ArrayList<>();

        try{
            Connection con = ClienteDao.getConnection();
            PreparedStatement ps=con.prepareStatement("select * from Clientes");
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                Cliente cliente = new Cliente();

                //Get DataBase Fields to Cliente Object
                FieldsGet(rs, cliente);

                list.add(cliente);
            }
            con.close();
        }catch(Exception ex){ex.printStackTrace();}

        return list;
    }

    private static void FieldsGet(ResultSet rs, Cliente cliente) throws SQLException {
        cliente.setId(rs.getInt(1));
        cliente.setNome(rs.getString(2));
        cliente.setNascimento(rs.getString(3));
        cliente.setCpf(rs.getString(4));
        cliente.setRg(rs.getString(5));
        cliente.setOrgao_emissor(rs.getString(6));
        cliente.setEmail(rs.getString(7));
        cliente.setTelefone(rs.getString(8));
        cliente.setWhats(rs.getBoolean(9));
        cliente.setLogradouro(rs.getString(10));
        cliente.setNumero(rs.getString(11));
        cliente.setBairro(rs.getString(12));
        cliente.setCidade(rs.getString(13));
        cliente.setEstado(rs.getString(14));
    }
}
