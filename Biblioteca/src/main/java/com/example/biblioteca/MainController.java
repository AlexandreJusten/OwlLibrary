package com.example.biblioteca;

import javafx.fxml.FXML;
import javafx.scene.control.*;

import javax.swing.table.TableColumn;
import javax.swing.text.TabableView;

public class MainController {

    @FXML
    private TabableView tabableViewLivros;
    @FXML
    private TableColumn tableColumnTitulo;
    @FXML
    private TableColumn tableColumnAssunto;
    @FXML
    private TableColumn tableColumnAutor;
    @FXML
    private SplitMenuButton splitMenuButtonAssunto;
    @FXML
    private TextField textFieldPesquisa;
    @FXML
    private Button buttonPesquisa;

    @FXML
    private Label labelUserConected;

    @FXML
    public void initialize(){
        labelUserConected.setText(LoginController.userConected);
    }



    public void PesquisaButtonClick(){

        System.out.println("pesquisa");


    }


    public void TextFieldPesquisaClick(){


    }



}