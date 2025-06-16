package utils;

import dao.*;

import java.sql.Connection;

public class TesteConexao {
    public static void main(String[] args) {
        Conexao conexao = new Conexao();
        Connection con = conexao.getConexao();

        if(con != null){
            System.out.println("Conexao estabelecida com sucesso!");
            try {
//                UsuariosDAO usuariosDAO = new UsuariosDAO();
//                usuariosDAO.inserirUsuario();
//                System.out.println("Usuario Inserido com sucesso!");
//
//                AdicionaisDAO adicionaisDAO = new AdicionaisDAO();
//                adicionaisDAO.inserirAdicionais();
//
//                ClientesDAO clientesDAO = new ClientesDAO();
//                clientesDAO.inserirClientes();
//
//                QuartosDAO quartosDAO = new QuartosDAO();
//                quartosDAO.inserirUsuario();
//
//                RoleDAO roleDAO = new RoleDAO();
//                roleDAO.inserirCargo();

//                PedidosDAO pedidosDAO = new PedidosDAO();
//                pedidosDAO.inserirPedidos();

                PedidosDAO pedidosDAO = new PedidosDAO();
                pedidosDAO.pesquisarPedidos();


//                ReservasDAO reservasDAO = new ReservasDAO();
//                reservasDAO.inserirReserva();



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
