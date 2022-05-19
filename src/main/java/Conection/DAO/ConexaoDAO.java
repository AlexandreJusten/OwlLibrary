package Conection.DAO;

import com.example.biblioteca.LoginController;
import javafx.application.Platform;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Objects;
import javax.swing.JOptionPane;



public class ConexaoDAO {


    public Connection conectaBD(UserBanco userBanco) throws IOException {

        Connection conn =null;
        userBanco.InicializarUserDatabaseTxt();

        try {
            String url = "jdbc:mysql://localhost:3306/LivrariaDDS?user="+userBanco.getUser()+"&password="+userBanco.getPassword();
            conn = DriverManager.getConnection(url);
        }
        catch (SQLException erro){

            JOptionPane.showMessageDialog(null,"Erro na Class de ConexãoDAO!!\n"+erro.getMessage());

            if(Objects.equals(erro.getMessage(), "Unknown database 'LivrariaDDS'")){
                JOptionPane.showMessageDialog(null,"O Software detectou a falta do DataBase LivrariaDDS\nEla será criada Automaticamente!!");
                try {
                    String url = "jdbc:mysql://localhost:3306/?user="+userBanco.getUser()+"&password="+userBanco.getPassword();
                    conn = DriverManager.getConnection(url);
                    DataBaseUseDAO.CreateDataBaseforNotExist(userBanco,conn);
                }
                catch (SQLException er){
                    JOptionPane.showMessageDialog(null,"Erro Critico na Class de ConexãoDAO-Criação de DataBase!!\nEntre em contato com a Assistencia\n"+erro.getMessage());
                    Platform.exit();
                }
                return null;
            }
        }

        return conn;
    }

}
