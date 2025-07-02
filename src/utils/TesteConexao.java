package utils;

import controller.UsuariosController;
import model.Usuario;

import java.sql.Connection;

public class TesteConexao {
    public static void main(String[] args) {
        Conexao conexao = new Conexao();
        Usuario usuario = new Usuario("Matheus", "matheus@gmail.com", 1, "123");
        Connection con = conexao.getConexao();

        if(con != null){
            System.out.println("Conexao estabelecida com sucesso!");
        }else{
            try {
                UsuariosController usuariosController = new UsuariosController();
                usuariosController.verificarCredenciais("matheus@gmail.com", "admin");

                con.close();
                System.out.println("Conexao Encerrada");
            }
            catch (Exception e) {
                System.out.println("Conexao Erro ao encerrar conexao!" + e.getMessage());
            }
            System.out.println("Falha ao se conectar!");
        }
    }    
}
