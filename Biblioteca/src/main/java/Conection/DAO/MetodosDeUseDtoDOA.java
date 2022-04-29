package Conection.DAO;

import Conection.DTO.ClientesDTO;

import javax.swing.*;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Objects;

public class MetodosDeUseDtoDOA {


    private static PreparedStatement pstm;


    public static void RegistrarCliente(ClientesDTO clientesDTO) throws IOException {



        String sql = "insert into cliente(nomedelogin,nomecompleto,telefone,endereco,senha) values (?,?,?,?,?);";
        UserBanco userBanco = new UserBanco();
        Connection conn =new ConexaoDAO().conectaBD(userBanco);

        if(VerificarCadastro(clientesDTO.getNomedelogin(),conn)){
            JOptionPane.showMessageDialog(null,"Erro-Usuario ja Cadastrado!!");
        }
        else {


            try {
                pstm = conn.prepareStatement(sql);
                pstm.setString(1, clientesDTO.getNomedelogin());
                pstm.setString(2, clientesDTO.getNomeCompleto());
                pstm.setInt(3, clientesDTO.getTelefone());
                pstm.setString(4, clientesDTO.getEndereco());
                pstm.setString(5, HashCode(clientesDTO.getSenha()));
                pstm.execute();
                pstm.close();
            } catch (Exception erro) {
                JOptionPane.showMessageDialog(null, "Cadastrar-MetodosDeUseDtoDAO" + erro);
            }
        }
    }
    public static boolean CallNamesforLogin(String inputName,String inputPassword,Connection conn) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        ResultSet rs;
        String sql ="select nomedelogin,senha from cliente where nomedelogin like "+"'"+inputName+"'";

        try {
            pstm =conn.prepareStatement(sql);
            rs =pstm.executeQuery();

            while (rs.next()) {
                if(Objects.equals(rs.getString("nomedelogin"), inputName)){
                    if(Objects.equals(rs.getString("senha"), HashCode(inputPassword))){
                        return true;
                    }
                }
            }

        }
        catch (Exception erro){
            JOptionPane.showMessageDialog(null,"Não foi possivel acessar a tabela cliente!!"+erro.getMessage());
        }
        return false;
    }
    public static boolean VerificarCadastro(String inputName,Connection conn){
        ResultSet rs;
        String sql ="select nomedelogin from cliente where nomedelogin like "+"'"+inputName+"'";

        try {
            pstm =conn.prepareStatement(sql);
            rs =pstm.executeQuery();

            while (rs.next()) {
                if(Objects.equals(rs.getString("nomedelogin"), inputName)){
                    return true;
                }
            }

        }
        catch (Exception erro){
            JOptionPane.showMessageDialog(null,"Não foi possivel acessar a tabela cliente!!"+erro.getMessage());
        }
        return false;
    }

public static String HashCode(String password) throws NoSuchAlgorithmException, UnsupportedEncodingException {

    MessageDigest algorithm = MessageDigest.getInstance("SHA-256");
    byte[] messageDigest = algorithm.digest(password.getBytes(StandardCharsets.UTF_8));

    StringBuilder hexString = new StringBuilder();
    for (byte b : messageDigest) {
        hexString.append(String.format("%02X", 0xFF & b));
    }
    return hexString.toString();
}
}
