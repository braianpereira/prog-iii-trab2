package br.dev.grancode.dao;

import br.dev.grancode.modelo.Usuario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDao extends Dao{

    public static int inserir(Usuario usuario) {
        int status = 0;

        try {
            Connection con= UsuarioDao.getConnection();

            // Preparar uma sentença SQL;
            PreparedStatement ps = con.prepareStatement(
                    "insert into Usuarios (CPF, Nome, Data_Nascimento, Email, Telefone, Whats, Username, Senha) " +
                            "values (?, ?, ?, ?, ?, ?, ?, ?)");
//                            "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

            // Parametrizar a senteça SQL;
            ps.setString(1, usuario.getCpf());
            ps.setString(2, usuario.getNome());
            ps.setString(3, usuario.getNascimento());
            ps.setString(4, usuario.getEmail());
            ps.setString(5, usuario.getTelefone());
            ps.setBoolean(6, usuario.isWhats());
            ps.setString(7, usuario.getUsername());
            ps.setString(8, usuario.getMd5Senha());

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

    public static int atualizar(Usuario usuario) {
        int status = 0;

        try {
            Connection con=UsuarioDao.getConnection();

            // Preparar uma sentença SQL;
            PreparedStatement ps = con.prepareStatement(
                    "update Usuarios set CPF = ?, Nome = ?, Data_Nascimento = ?, Email = ?, " +
                            "Telefone = ?, Whats = ?, Username = ?, Senha = ?" +
                            "WHERE CPF = ?");

            // Parametrizar a senteça SQL;
            FieldsSet(usuario, ps);

            ps.setString(9, usuario.getPk());

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

    private static void FieldsSet(Usuario usuario, PreparedStatement ps) throws SQLException {
        ps.setString(1, usuario.getCpf());
        ps.setString(2, usuario.getNome());
        ps.setDate(3, Date.valueOf(usuario.getNascimento()));
        ps.setString(4, usuario.getEmail());
        ps.setString(5, usuario.getTelefone());
        ps.setBoolean(6, usuario.isWhats());
        ps.setString(7, usuario.getUsername());
        ps.setString(8, usuario.getMd5Senha());
    }

    public static int excluir(String cpf) {
        int status=0;
        try{
            Connection con= UsuarioDao.getConnection();
            PreparedStatement ps=con.prepareStatement("delete from Usuarios where CPF = ?");
            ps.setString(1,cpf);
            status=ps.executeUpdate();

            con.close();
        }catch(Exception e){e.printStackTrace();}

        return status;
    }

    public static Usuario getUsuarioPorCpf(String cpf) {
        Usuario usuario = new Usuario();
        try{
            Connection con = UsuarioDao.getConnection();
            PreparedStatement ps=con.prepareStatement("select * from Usuarios where CPF = ?");
            ps.setString(1,cpf);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                usuarioGetFields(usuario, rs);
            }
            con.close();
        }catch(Exception ex){ex.printStackTrace();}

        return usuario;
    }

    private static void usuarioGetFields(Usuario usuario, ResultSet rs) throws SQLException {
        usuario.setCpf(rs.getString(1));
        usuario.setNome(rs.getString(2));
        usuario.setNascimento(rs.getString(3));
        usuario.setEmail(rs.getString(4));
        usuario.setTelefone(rs.getString(5));
        usuario.setWhats(rs.getBoolean(6));
        usuario.setUsername(rs.getString(7));
    }

    public static List<Usuario> getAllUsuarios() {
        List<Usuario> list = new ArrayList<>();

        try{
            Connection con = UsuarioDao.getConnection();
            PreparedStatement ps=con.prepareStatement("select * from Usuarios");
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                Usuario usuario = new Usuario();

                usuarioGetFields(usuario, rs);

                list.add(usuario);
            }
            con.close();
        }catch(Exception ex){ex.printStackTrace();}

        return list;
    }
}
