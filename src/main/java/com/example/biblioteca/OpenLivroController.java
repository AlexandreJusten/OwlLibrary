package com.example.biblioteca;

import Conection.DAO.ConexaoDAO;
import Conection.DAO.MetodosDeUseDtoDOA;
import Conection.DAO.UserBanco;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

public class OpenLivroController {

    @FXML
    private Button comprar;

    @FXML
    private Label titulo;

    @FXML
    private Label nomeeditora;
    @FXML
    private Label nomeautor;
    @FXML
    private Label nomeassunto;
    @FXML
    private Label nomeestoque;
    @FXML
    private Label nomecategoria;

    private String teste;
    UserBanco userBanco = new UserBanco();
    Connection conn =new ConexaoDAO().conectaBD(userBanco);
    MetodosDeUseDtoDOA metodosDeUseDtoDOA = new MetodosDeUseDtoDOA();
    ArrayList<ComponentLivrosDTOList> arrayList = new ArrayList();

    public OpenLivroController() throws IOException {
    }

    @FXML
    public void initialize() throws IOException {


        arrayList=metodosDeUseDtoDOA.ReturnLivrosPesquisa(conn,MainController.tituloParaScene);
        teste="fwa";
        titulo.setText(arrayList.get(0).getTitulo());
        nomeeditora.setText(teste);
        nomeautor.setText(arrayList.get(0).getAutor());
        nomeassunto.setText(arrayList.get(0).getAssunto());
        nomeestoque.setText(String.valueOf(arrayList.get(0).getEstoque()));
        nomecategoria.setText(teste);
    }


    public void ButtonComprarclicked() throws IOException {
        metodosDeUseDtoDOA.ComprarLivro(arrayList.get(0).getId(),metodosDeUseDtoDOA.ReturnClientConected(LoginController.userConected,conn));
        JOptionPane.showMessageDialog(null,"Compra Realizada com Sucesso!!");
        Stage stage = (Stage) comprar.getScene().getWindow();
        stage.close();
    }
}
