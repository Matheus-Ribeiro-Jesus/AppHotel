package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    private String driver = "com.mysql.cj.jdbc.Driver";
    private String url = "jdbc:mysql://127.0.0.1:3306/projecthotel";
    private String usuario = "dbaHotel";
    private String senha = "dbaHotel123";

    Connection condb = null;

    public Connection getConexao(){
        try{
            // Especifica a rota do Driver a ser Carregada JDBC para MySQL

            Class.forName(driver);

            // Inicializar o driver ja carregado por meio do metodo getConnection(IP, porta, nome do banco, usuario, senha)

            condb = DriverManager.getConnection(url, usuario, senha);
            return condb;

        }
        catch(SQLException erro){
            System.out.println("Erro ao se conectar ao banco de dados" + erro);
            return null;
        }
    }
}
