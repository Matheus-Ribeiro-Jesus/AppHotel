package dao;

import model.Usuario;
import utils.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
            con.close();
            return linhaAfetada > 0;
        }catch (Exception erro){
            System.out.println("Erro ao inserir quartos! " + erro.getMessage());
            return false;
        }
    }
    public boolean removerQuartos() {
        try{
            Connection con = conexao.getConexao();
            PreparedStatement removerQuartos = con.prepareStatement("DELETE FROM quartos WHERE id = ?;");
            removerQuartos.setInt(1,1);
            int linhaAfetada = removerQuartos.executeUpdate();
            con.close();
            return linhaAfetada > 0;
        }catch (Exception erro){
            System.out.println("Erro ao remover quartos! " + erro.getMessage());
            return false;
        }
    }
    public boolean AtualizarPedidos(){
        try{
            Connection con = conexao.getConexao();
            PreparedStatement atualizarQuartos = con.prepareStatement("UPDATE quartos SET nome = ?, numero = ?, qtd_cama_casal = ?, qtd_cama_solteiro = ?, preco = ?, disponivel = ? WHERE id = ?;");
            atualizarQuartos.setString(1,"Cama de casal");
            atualizarQuartos.setString(2,"230");
            atualizarQuartos.setInt(3,1);
            atualizarQuartos.setInt(4,2);
            atualizarQuartos.setDouble(5,1.500);
            atualizarQuartos.setInt(6,4);
            int linhaAfetada = atualizarQuartos.executeUpdate();
            con.close();
            return linhaAfetada > 0;
        }catch (Exception erro){
            System.out.println("Erro ao atualizar quartos! " + erro.getMessage());
            return false;
        }
    }

    public void pesquisarQuartos(){
        try{
            Connection con = conexao.getConexao();
            PreparedStatement pesquisarQuartos = con.prepareStatement("SELECT nome, numero, qtd_cama_casal, qtd_cama_solteiro, preco, disponivel FROM quartos WHERE id = ?; ");
            pesquisarQuartos.setInt(1, 2);

            ResultSet resultado = pesquisarQuartos.executeQuery();

            while(resultado.next()){
                String nome = resultado.getString("Nome");
                String numero = resultado.getString("Numero");
                int qtd_cama_casal = resultado.getInt("qtd_cama_casal");
                int qtd_cama_solteiro = resultado.getInt("qtd_cama_solteiro");
                double preco = resultado.getDouble("Preço");
                int disponiveis = resultado.getInt("Disponiveis");
                System.out.println("Nome: " + nome + "Numero: " + numero + "qtd_cama_casal: " + qtd_cama_casal + "qtd_cama_solteiro " + qtd_cama_solteiro + "Preço: " + preco + "disponiveis: " + disponiveis);
            }
            con.close();
        }catch (Exception erro){
            System.out.println("Erro ao pesquisarQuartos! " + erro.getMessage());
        }
    }
}
