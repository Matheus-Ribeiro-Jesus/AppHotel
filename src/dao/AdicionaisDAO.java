package dao;

import utils.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class AdicionaisDAO {
    private Conexao conexao = new Conexao();

    public boolean inserirAdicionais(){
        try{
            Connection con = conexao.getConexao();
            PreparedStatement novoAdicionais = con.prepareStatement("INSERT INTO adicionais(nome, preco) VALUES(?, ?);");
            novoAdicionais.setString(1, "Café da manha");
            novoAdicionais.setDouble(2, 350);

            int linhaAfetada = novoAdicionais.executeUpdate();
            return linhaAfetada > 0;
        }catch (Exception erro){
            System.out.println("Erro ao inserir adicionais! " + erro.getMessage());
            return false;
        }
    }
}
