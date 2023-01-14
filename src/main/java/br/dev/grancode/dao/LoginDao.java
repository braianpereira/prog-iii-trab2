package br.dev.grancode.dao;

import br.dev.grancode.modelo.Login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDao extends Dao{
    public static Boolean verificarCredenciais(Login login) {
        boolean temUsuario = false;
        try {
            Connection con = LoginDao.getConnection();

            PreparedStatement ps = con.prepareStatement("SELECT * FROM Usuarios WHERE Username = ? AND Senha = ? ");
            ps.setString(1, login.getUsername());
            ps.setString(2, login.getMd5Senha());

            ResultSet rs = ps.executeQuery();

            temUsuario = rs.next();

            rs.close();
            ps.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return temUsuario;
    }
}
