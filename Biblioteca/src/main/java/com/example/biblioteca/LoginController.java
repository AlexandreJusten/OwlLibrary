package com.example.biblioteca;

import Conection.DAO.ConexaoDAO;
import Conection.DAO.MetodosDeUseDtoDOA;
import Conection.DAO.UserBanco;
import Conection.DTO.ClientesDTO;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.swing.JOptionPane;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.util.Objects;

public  class LoginController {

    @FXML
    private Button buttonEntrar;
    @FXML
    private Button buttonCadastrar;
    @FXML
    private TextField textFieldNome;
    @FXML
    private PasswordField passwordFieldSenha;
    static String userConected;


    public void LoginVerificar() throws IOException, NoSuchAlgorithmException {

            UserBanco userBanco = new UserBanco();
            Connection conn =new ConexaoDAO().conectaBD(userBanco);
            boolean a=MetodosDeUseDtoDOA.CallNamesforLogin(textFieldNome.getText(),passwordFieldSenha.getText(),conn);

            if (a){
                userConected=textFieldNome.getText();
                try {
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("main.fxml"));
                    Stage window = (Stage) buttonEntrar.getScene().getWindow();
                    window.setScene(new Scene(fxmlLoader.load(),1050,600));
                    if(Objects.equals(textFieldNome.getText(), "Admin")){
                        window.setTitle("Biblioteca-Inicio-"+textFieldNome.getText());
                    }

                }
                catch (Exception erro){
                    JOptionPane.showMessageDialog(null,"Erro ao carregar a tela Principal!!"+erro);
                }

            }
            else {
                JOptionPane.showMessageDialog(null,"Nome ou Senha Incorretos!!");
            }

    }

    public void Registrar() throws IOException {

        ClientesDTO clientesDTO =new ClientesDTO();
        clientesDTO.setNomedelogin(JOptionPane.showInputDialog("Nome para Login"));
        clientesDTO.setNomeCompleto(JOptionPane.showInputDialog("Nome Completo"));
        clientesDTO.setTelefone(Integer.parseInt(JOptionPane.showInputDialog("Telefone")));
        clientesDTO.setEndereco(JOptionPane.showInputDialog("Endereço"));
        clientesDTO.setSenha(JOptionPane.showInputDialog("Senha"));
        MetodosDeUseDtoDOA.RegistrarCliente(clientesDTO);

    }

}