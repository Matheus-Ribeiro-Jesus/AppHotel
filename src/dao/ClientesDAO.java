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

            novoCliente.setString(1, "Matheus");
            novoCliente.setString(2, "123-456-789");
            novoCliente.setString(3, "admin");
            novoCliente.setString(4, "123456@gmail.com");

            int linhaAfetada = novoCliente.executeUpdate();
            return linhaAfetada > 0;
        }catch (Exception erro){
            System.out.println("Erro ao inserir clientes! " + erro.getMessage());
            return false;
        }
    }
}
