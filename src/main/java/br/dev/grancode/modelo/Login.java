package br.dev.grancode.modelo;

import br.dev.grancode.dao.LoginDao;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Login {
    private String username;
    private String senha;
    private String md5Senha;

    public Login(String username, String senha) {
        this.senha = senha;
        this.username = username;
        this.md5Senha = MD5(senha);
    }

    private String MD5(String input){
        try {

            // Static getInstance method is called with hashing MD5
            MessageDigest md = MessageDigest.getInstance("MD5");

            // digest() method is called to calculate message digest
            // of an input digest() return array of byte
            byte[] messageDigest = md.digest(input.getBytes());

            // Convert byte array into signum representation
            BigInteger no = new BigInteger(1, messageDigest);

            // Convert message digest into hex value
            String hashtext = no.toString(16);
            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }
            return hashtext;

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean doLogin() {

        return LoginDao.verificarCredenciais(this);
    }

    public String getUsername() {
        return username;
    }

    public String getSenha() {
        return senha;
    }

    public String getMd5Senha() {
        return md5Senha;
    }
}
