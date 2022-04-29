package com.example.biblioteca;

import Conection.DAO.ConexaoDAO;
import Conection.DAO.UserBanco;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import staticJavaApl.StaticMain;
import javax.swing.*;
import java.io.IOException;
import java.sql.Connection;

public class Loading {

    @FXML
    private AnchorPane anchorPaneEntrar;

    public Connection conn;

    public UserBanco userBanco = new UserBanco();



    public void main() throws IOException {

        this.conn =new ConexaoDAO().conectaBD(userBanco);

        if (conn==null){
          userBanco.setUser(JOptionPane.showInputDialog("Usuario do Banco"));
           userBanco.setPassword( JOptionPane.showInputDialog("Senha do Banco"));
            StaticMain staticMain = new StaticMain();
            staticMain.EscreverUser(userBanco.getUser(), userBanco.getPassword());

        }
        else {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("login.fxml"));
            Stage window = (Stage) anchorPaneEntrar.getScene().getWindow();
            window.setScene(new Scene(fxmlLoader.load(), 1050, 600));
            window.setTitle("Biblioteca-login");
        }
    }
}
