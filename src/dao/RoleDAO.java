package dao;

import javafx.scene.layout.BorderPane;
import utils.Conexao;

import javax.imageio.plugins.jpeg.JPEGImageReadParam;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class RoleDAO {
    private Conexao conexao = new Conexao();

    public boolean inserirCargo(){
        try{
            Connection con = conexao.getConexao();
            PreparedStatement newRole = con.prepareStatement("INSERT INTO roles(nome) VALUES(?);");
            newRole.setString(1, "Dono");
            int linhaAfetada = newRole.executeUpdate();
            con.close();
            return linhaAfetada > 0;
        }catch (Exception e){
            System.out.println("Erro ao inserir role!" + e.getMessage());
            return false;
        }
    }

    public boolean removeRole(){
        try{
            Connection con = conexao.getConexao();
            PreparedStatement RemoverRole = con.prepareStatement("DELETE FROM roles WHERE id = ?;");
            RemoverRole.setInt(1,1);
            int linhaAfetada = RemoverRole.executeUpdate();
            con.close();
            return linhaAfetada > 0;
        }catch (Exception e){
            System.out.println("Erro ao remover cargo! " + e.getMessage());
            return false;
        }
    }
    public boolean atualizarcargos(){
        try{
            Connection con = conexao.getConexao();
            PreparedStatement atualizarCargos = con.prepareStatement("UPDATE roles SET nome = ? WHERE id = ?;");
            atualizarCargos.setInt(1,3);
            int linhaAfetada = atualizarCargos.executeUpdate();
            con.close();
            return linhaAfetada > 0;
        }catch (Exception erro){
            System.out.println("Erro ao atualizar cargos! " + erro.getMessage());
            return false;
        }
    }
    public void pesquisarcargos(){
        try {
            Connection con = conexao.getConexao();
            PreparedStatement pesquicargos = con.prepareStatement("SELECT nome FROM roles WHERE id = ?;");
            pesquicargos.setString(1,"Administrador");
            ResultSet resultado = pesquicargos.executeQuery();
            while(resultado.next()){
                String nome = resultado.getString("Nome");
                System.out.println("Nome: " + nome);
            }
            con.close();
        }catch (Exception erro){
            System.out.println("Erro ao pesquisar cargos! " + erro.getMessage());
        }
    }
}
