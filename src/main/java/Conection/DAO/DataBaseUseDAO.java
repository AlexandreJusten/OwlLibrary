package Conection.DAO;

import javax.swing.*;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Objects;

public class DataBaseUseDAO {

    private static Connection conn;
    private static PreparedStatement pstm;
    static ResultSet rs;

    public static void CreateDataBaseforNotExist(UserBanco user,Connection conn) throws IOException, SQLException {
        Statement s = conn.createStatement();
        s.executeUpdate("CREATE DATABASE LivrariaDDS");
        s.close();
        RodarScriptSql();
    }

    public static void RodarScriptSql(){

        System.out.println("fazer rodar o script sql Livraria");

    }


}
