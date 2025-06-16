package dao;

import utils.Conexao;

import java.sql.*;

public class ReservasDAO {
    private Conexao conexao = new Conexao();

    public boolean deletarReserva(){
        try {
            Connection con = conexao.getConexao();
            PreparedStatement deleteReservas = con.prepareStatement("DELETE FROM reservas WHERE id = ?;");
            deleteReservas.setInt(1,1);
            int linhaReservas = deleteReservas.executeUpdate();
            return linhaReservas > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao deletar reservas" + e.getMessage());
            return false;
        }
    }

    public boolean inserirReserva(){
        try {
            Connection con = conexao.getConexao();
            PreparedStatement InserirReserva = con.prepareStatement("INSERT INTO reservas(pedido_id, quarto_id, adicional_id, inicio, fim) VALUES(?, ?, ?, ?, ?);");
            InserirReserva.setInt(1,4);
            InserirReserva.setInt(2,2);
            InserirReserva.setInt(3,2);
            InserirReserva.setDate(4, Date.valueOf("2025-06-10"));
            InserirReserva.setDate(5, Date.valueOf("2025-06-12"));
            int linhaReservas = InserirReserva.executeUpdate();
            return linhaReservas > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao inserir a reserva" + e.getMessage());
            return false;
        }
    }
    public boolean atualizarReservas(){
        try{
            Connection con = conexao.getConexao();
            PreparedStatement atualizarReservas = con.prepareStatement("UPDATE reservas SET pedido_id = ?, quarto_id = ?, adicional_id, inicio, fim = ? WHERE id = ?;");
            atualizarReservas.setInt(1,4);
            atualizarReservas.setInt(2,2);
            atualizarReservas.setInt(3,2);
            atualizarReservas.setDate(4, Date.valueOf("2025-06-21"));
            atualizarReservas.setDate(5, Date.valueOf("2025-06-22"));
            int linhaAfetada = atualizarReservas.executeUpdate();
            con.close();
            return linhaAfetada > 0;
        }catch (Exception erro){
            System.out.println("Erro ao atualizar reservas! " + erro.getMessage());
            return false;
        }
    }

    public void pesquisarReservas() {
        try (Connection con = conexao.getConexao();
             PreparedStatement pesquisareservar = con.prepareStatement("SELECT pedido_id, quarto_id, adicional_id, inicio, fim FROM reservas WHERE id = ?")) {
            pesquisareservar.setInt(1, 2);
            try (ResultSet resultado = pesquisareservar.executeQuery()) {
                while (resultado.next()) {
                    int pedido_id = resultado.getInt("pedido_id");
                    int quarto_id = resultado.getInt("quarto_id");
                    int adicional_id = resultado.getInt("adicional_id");
                    String inicio = resultado.getString("inicio");
                    String fim = resultado.getString("fim");
                    System.out.printf("Pedido ID: %d, Quarto ID: %d, Adicional ID: %d, Início: %s, Fim: %s%n", pedido_id, quarto_id, adicional_id, inicio, fim);
                }
            }
        } catch (SQLException erro) {
            System.out.println("Erro ao pesquisar reservas! " + erro.getMessage());
        }
    }
}
