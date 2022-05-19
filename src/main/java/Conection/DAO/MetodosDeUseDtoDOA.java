package Conection.DAO;

import Conection.DTO.ClientesDTO;
import com.example.biblioteca.ComponentLivrosDTOList;
import javax.swing.*;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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

    public ArrayList<ComponentLivrosDTOList> ReturnLivrosPesquisa(Connection conn,String titulo) {


    ArrayList<ComponentLivrosDTOList> listalivros = new ArrayList();

    ResultSet rs;
    String sql = "select * from livro where titulo like '%"+titulo+"%'";

    try {

        pstm = conn.prepareStatement(sql);
        rs = pstm.executeQuery();

        while (rs.next()) {


            ComponentLivrosDTOList livro = new ComponentLivrosDTOList(rs.getInt("id"),rs.getString("titulo"),rs.getString("assunto"),rs.getString("autor"),rs.getInt("estoque"),rs.getInt("editora_id"),rs.getInt("categoria_id"));
            listalivros.add(livro);
        }

    } catch (Exception erro) {
        JOptionPane.showMessageDialog(null, "Não foi possivel acessar a tabela cliente!!" + erro.getMessage());
    }
    return listalivros;
}

    public ArrayList<ComponentLivrosDTOList> ReturnLivros(Connection conn) {


        ArrayList<ComponentLivrosDTOList> listalivros = new ArrayList();

        ResultSet rs;
        String sql = "select * from livro";

        try {

            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();

            while (rs.next()) {


                ComponentLivrosDTOList livro = new ComponentLivrosDTOList(rs.getInt("id"),rs.getString("titulo"),rs.getString("assunto"),rs.getString("autor"),rs.getInt("estoque"),rs.getInt("editora_id"),rs.getInt("categoria_id"));
                listalivros.add(livro);
            }

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Não foi possivel acessar a tabela cliente!!" + erro.getMessage());
        }
        return listalivros;
    }

    public void ComprarLivro(int idlivro,int idcliente) throws IOException {


            String sql = "insert into venda(livro_id,cliente_id,date) values (?,?,?)";
            UserBanco userBanco = new UserBanco();
            Connection conn =new ConexaoDAO().conectaBD(userBanco);


                try {
                    pstm = conn.prepareStatement(sql);
                    pstm.setInt(1, idlivro);
                    pstm.setInt(2, idcliente);
                    String timeStamp = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());
                    pstm.setString(3,timeStamp);
                    pstm.execute();
                    pstm.close();
                } catch (Exception erro) {
                    JOptionPane.showMessageDialog(null, "ComprarLivro-MetodosDeUseDtoDAO" + erro);
                }
            }

    public int ReturnClientConected(String nome,Connection conn) throws IOException {
        ResultSet rs;
        String sql ="select * from cliente where nomedelogin like "+"'"+nome+"'";

        try {
            pstm =conn.prepareStatement(sql);
            rs =pstm.executeQuery();
            while (rs.next()){
              return rs.getInt("id");
            }

        }
        catch (Exception erro){
            JOptionPane.showMessageDialog(null,"Não foi possivel acessar a tabela cliente!!"+erro.getMessage());
            return 0;
        }

        return 0;
    }
}

