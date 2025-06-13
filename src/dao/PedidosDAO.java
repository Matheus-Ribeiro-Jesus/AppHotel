package dao;

import utils.Conexao;

import java.sql.*;

public class PedidosDAO {
    private Conexao conexao = new Conexao();

    public boolean inserirPedidos(){
        try{
            Connection con = conexao.getConexao();
            PreparedStatement newPedidos = con.prepareStatement("INSERT INTO pedidos(pagamento, usuario_id, cliente_id) VALUES(?, ?, ?);");
            newPedidos.setString(1,  "Dinheiro");
            newPedidos.setInt(2,3 );
            newPedidos.setInt(3, 5);
            int linhaAfetada = newPedidos.executeUpdate();
            return linhaAfetada > 0;
        }catch (SQLException erro){
            System.out.println("Erro ao inserirPedidos: " + erro.getMessage());
        return false;
        }
    }
    public boolean deletarPedidos(){
        try {
            Connection con = conexao.getConexao();
            PreparedStatement deletePedidos = con.prepareStatement("DELETE FROM pedidos WHERE id = ?;");
            deletePedidos.setInt(1,1);
            int linhaReservas = deletePedidos.executeUpdate();
            return linhaReservas > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao deletar reservas" + e.getMessage());
            return false;
        }
    }
    public boolean AtualizarPedidos(){
        try{
            Connection con = conexao.getConexao();
            PreparedStatement atualizarPedidos = con.prepareStatement("UPDATE pedidos SET pagamento = ?, usuario_id = ?, cliente_id = ? WHERE id = ?;");
            atualizarPedidos.setString(1,  "Dinheiro");
            atualizarPedidos.setInt(2,3 );
            atualizarPedidos.setInt(3, 2);
            int linhaAfetada = atualizarPedidos.executeUpdate();
            con.close();
            return linhaAfetada > 0;
        }catch (Exception erro){
            System.out.println("Erro ao atualizar pedidos! " + erro.getMessage());
            return false;
        }
    }

    public void pesquisarPedidos(){
        try {
            Connection con = conexao.getConexao();
            PreparedStatement pesquisarpedidos = con.prepareStatement("SELECT pagamento, usuario_id, cliente_id FROM pedidos WHERE id = ?;");
            pesquisarpedidos.setString(1,  "Pix");
            pesquisarpedidos.setInt(2, 4);
            pesquisarpedidos.setInt(3, 2);
            ResultSet resultado = pesquisarpedidos.executeQuery();

            while (resultado.next()){
                String nome = resultado.getString("pagamento");
                String usuario_id = resultado.getString("usuario_id");
                String cliente_id = resultado.getString("cliente_id");
                System.out.println("Nome: " + nome + " Usuario: " + usuario_id + " Cliente: " + cliente_id);
            }
            con.close();
        }catch (Exception error){
            System.out.println("Erro ao pesquisarPedidos: " + error.getMessage());
        }
    }

}
