package dao;

import javafx.scene.layout.BorderPane;
import utils.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class RoleDAO {
    private Conexao conexao = new Conexao();

    public boolean inserirCargo(){
        try{
            Connection con = conexao.getConexao();
            PreparedStatement newRole = con.prepareStatement("INSERT INTO roles(nome) VALUES(?);");
            newRole.setString(1, "Dono");
            int linhaAfetada = newRole.executeUpdate();
            return linhaAfetada > 0;
        }catch (Exception e){
            System.out.println("Erro ao inserir role!" + e.getMessage());
            return false;
        }
    }
}
