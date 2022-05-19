package com.example.biblioteca;

import Conection.DAO.ConexaoDAO;
import Conection.DAO.MetodosDeUseDtoDOA;
import Conection.DAO.UserBanco;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MainController {

    MetodosDeUseDtoDOA metodosDeUseDtoDOA = new MetodosDeUseDtoDOA();
    public static String tituloParaScene;
    @FXML
    private TableView<ComponentLivrosDTOList> tableView;
    @FXML
    private TableColumn<ComponentLivrosDTOList,String> tableColumnTitulo;
    @FXML
    private TableColumn<ComponentLivrosDTOList,String> tableColumnAutor;
    @FXML
    private TableColumn<ComponentLivrosDTOList,String> tableColumnAssunto;
    private List<ComponentLivrosDTOList> listDeLivros = new ArrayList();
    private ObservableList<ComponentLivrosDTOList> observableList;

    @FXML
    private Button buttonPesquisa;

    @FXML
    private Button buttonSair;

    @FXML
    private Label labelUserConected;
    @FXML
    private TextField textFieldPesquisa;



    @FXML
    public void initialize() throws IOException {
        labelUserConected.setText(LoginController.userConected);
        IniciarListaDeLivros(false,"");
    }


    public void PesquisaButtonClick() throws IOException {

        if (Objects.equals(textFieldPesquisa.getText(), "")){
            IniciarListaDeLivros(false,"");
        }
        else {
            IniciarListaDeLivros(true, textFieldPesquisa.getText());
        }
    }

    public void TableviewClicked() throws IOException {
        if (tableView.getSelectionModel().getSelectedItem()!=null){
            tituloParaScene=tableView.getSelectionModel().getSelectedItem().getTitulo();
            CriarScene(tableView.getSelectionModel().getSelectedItem().getTitulo());
            IniciarListaDeLivros(false,"");
        }

    }


    public void TextFieldPesquisaClick(){


    }

    public void ButtonSairClicked() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("login.fxml"));
        Stage window = (Stage) buttonSair.getScene().getWindow();
        window.setScene(new Scene(fxmlLoader.load(), 1050, 600));
        window.setTitle("Biblioteca-login");
    }

    public void IniciarListaDeLivros(Boolean condicionpesquisa,String titulopesquisa) throws IOException {
        UserBanco userBanco = new UserBanco();
        Connection conn =new ConexaoDAO().conectaBD(userBanco);

        tableColumnTitulo.setCellValueFactory(new PropertyValueFactory<>("titulo"));
        tableColumnAssunto.setCellValueFactory(new PropertyValueFactory<>("assunto"));
        tableColumnAutor.setCellValueFactory(new PropertyValueFactory<>("autor"));
        if (condicionpesquisa){
            observableList=FXCollections.observableArrayList(metodosDeUseDtoDOA.ReturnLivrosPesquisa(conn,titulopesquisa));
        }
        else {
        observableList=FXCollections.observableArrayList(metodosDeUseDtoDOA.ReturnLivros(conn));}
        tableView.setItems(observableList);

    }

    public void CriarScene(String titulo) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("openlivro.fxml"));
        Scene scene = new Scene(root,500,500);
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);
        stage.setTitle("Livro-"+titulo);
    }

}