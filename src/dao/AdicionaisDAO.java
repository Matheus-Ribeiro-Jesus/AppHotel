package dao;

import utils.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AdicionaisDAO {
    private Conexao conexao = new Conexao();

    public boolean inserirAdicionais(){
        try{
            Connection con = conexao.getConexao();
            PreparedStatement novoAdicionais = con.prepareStatement("INSERT INTO adicionais(nome, preco) VALUES(?, ?);");
            novoAdicionais.setString(1, "Café da manha");
            novoAdicionais.setDouble(2, 350);

            int linhaAfetada = novoAdicionais.executeUpdate();
            con.close();
            return linhaAfetada > 0;
        }catch (Exception erro){
            System.out.println("Erro ao inserir adicionais! " + erro.getMessage());
            return false;
        }
    }

    public boolean deletarAdicionais(){
        try{
            Connection con = conexao.getConexao();
            PreparedStatement removeUsuario = con.prepareStatement("DELETE FROM adicionais WHERE id = ?;");
            removeUsuario.setInt(1,1);
            int linhaAfetada = removeUsuario.executeUpdate();
            con.close();
            return linhaAfetada > 0;
        }catch (Exception erro){
            System.out.println("Erro ao deletar adicionais! " + erro.getMessage());
            return false;
        }
    }

    public boolean atualizarAdicionais(){
        try{
            Connection con = conexao.getConexao();
            PreparedStatement atualizarAdicionais = con.prepareStatement("UPDATE adicionais SET nome = ?, preco = ? WHERE id = ?;");
            atualizarAdicionais.setString(1, "Café Preto");
            atualizarAdicionais.setDouble(2, 120.00);
            int linhaAfetada = atualizarAdicionais.executeUpdate();
            con.close();
            return linhaAfetada > 0;
        }catch (Exception erro){
            System.out.println("Erro ao atualizar adicionais! " + erro.getMessage());
            return false;
        }
    }
    public void pesquisarAdicionais(){
        try{
            Connection con = conexao.getConexao();
            PreparedStatement pesquisaradicionais = con.prepareStatement("SELECT adicionais nome, preco FROM adicionais WHERE id = ?;");
            pesquisaradicionais.setInt(1, 2);
            ResultSet resultado = pesquisaradicionais.executeQuery();
            while(resultado.next()){
                String nome = resultado.getString("nome");
                String preco = resultado.getString("Preço");
                System.out.println("Nome: " + nome + "Preço " + preco);
            }
            con.close();
        }catch (Exception erro){
            System.out.println("Erro ao pesquisar adicionais! " + erro.getMessage());
        }
    }
}
