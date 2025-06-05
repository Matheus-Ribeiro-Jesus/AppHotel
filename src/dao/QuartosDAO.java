package dao;

import model.Usuario;
import utils.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class QuartosDAO {

    private Conexao conexao = new Conexao();

    public boolean inserirUsuario() {
        try{
            Connection con = conexao.getConexao();
            PreparedStatement novoQuarto = con.prepareStatement("INSERT INTO quartos(nome, numero, qtd_cama_casal, qtd_cama_solteiro, preco, disponivel) VALUES(?, ?, ?, ?, ?, ?);");
            novoQuarto.setString(1,"Cama de casal");
            novoQuarto.setString(2,"201");
            novoQuarto.setInt(3,1);
            novoQuarto.setInt(4,10);
            novoQuarto.setDouble(5,1.500);
            novoQuarto.setInt(6,15);

            int linhaAfetada = novoQuarto.executeUpdate();
            return linhaAfetada > 0;
        }catch (Exception erro){
            System.out.println("Erro ao inserir quartos! " + erro.getMessage());
            return false;
        }
    }
}
