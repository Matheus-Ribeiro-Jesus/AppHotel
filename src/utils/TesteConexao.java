package utils;

import java.sql.Connection;

public class TesteConexao {
    public static void main(String[] args) {
        Conexao conexao = new Conexao();
        Connection con = conexao.getConexao();

        if(con != null){
            System.out.println("Conexao estabelecida com sucesso!");

            try {
                con.close();
                System.out.println("Conexao Encerrada");
            }

            catch (Exception e) {
                System.out.println("Conexao Erro ao encerrar conexao!" + e.getMessage());
            }
        }else{
            System.out.println("Falha ao se conectar!");
        }
    }    
}
