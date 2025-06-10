package dao;

import utils.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class ClientesDAO {
    private Conexao conexao = new Conexao();

    public boolean inserirClientes(){
        try{
            Connection con = conexao.getConexao();
            PreparedStatement novoCliente = con.prepareStatement("INSERT INTO clientes(nome, cpf, telefone, email) VALUES(?, ?, ?, ?); ");

            novoCliente.setString(1, "Diego");
            novoCliente.setString(2, "222-444-221");
            novoCliente.setString(3, "(21)1234-4444");
            novoCliente.setString(4, "Diego@gmail.com");

            int linhaAfetada = novoCliente.executeUpdate();
            con.close();
            return linhaAfetada > 0;
        }catch (Exception erro){
            System.out.println("Erro ao inserir clientes! " + erro.getMessage());
            return false;
        }
    }

    public boolean removerClientes(){
        try{
            Connection con = conexao.getConexao();
            PreparedStatement removerClientes = con.prepareStatement("DELETE FROM clientes WHERE id = ?;");
            removerClientes.setInt(1, 1);
            int linhaAfetada = removerClientes.executeUpdate();
            con.close();
            return linhaAfetada > 0;
        }catch (Exception erro){
            System.out.println("Erro ao remover clientes! " + erro.getMessage());
            return false;
        }
    }
    public boolean atualizarClientes(){
        try{
            Connection con = conexao.getConexao();
            PreparedStatement atualizarClientes = con.prepareStatement("UPDATE clientes SET nome = ?, cpf = ?, telefone = ?, email = ? WHERE id = ?;");
            atualizarClientes.setString(1, "Matheus Ribeiro");
            atualizarClientes.setString(2, "504-555-555");
            atualizarClientes.setString(3, "(21)1234-4344");
            atualizarClientes.setString(4, "matheusribeiro@gmail.com");
            int linhaAfetada = atualizarClientes.executeUpdate();
            con.close();
            return linhaAfetada > 0;
        }catch (Exception erro){
            System.out.println("Erro ao atualizar clientes! " + erro.getMessage());
            return false;
        }
    }
}
