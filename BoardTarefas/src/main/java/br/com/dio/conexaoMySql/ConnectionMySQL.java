package br.com.dio.conexaoMySql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionMySQL {
    private static final String URL = "jdbc:mysql://localhost:3306/task_db";
    private static final String USER = "root";

    private static final String PASSWORD = "root";

    public static Connection getConnection(){
        try{
            return DriverManager.getConnection(URL,USER,PASSWORD);
        }catch (SQLException exception){
            throw  new RuntimeException("ERROR CONNECTING TO DATABASE",exception);
        }
    }

//  teste de conexao com o banco
//  public static void main(String[] args) {
//        String url = "jdbc:mysql://localhost:3306/task_db";
//        String user = "root";
//        String password = "root";
//
//        try (Connection conn = DriverManager.getConnection(url, user, password)) {
//            System.out.println("Conexão bem-sucedida!");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
}
