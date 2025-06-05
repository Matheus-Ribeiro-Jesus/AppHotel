package dao;
import utils.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class UsuariosDAO {

    //Objeto para instanciar classe Conexao para requisitrar acesso ao DB

    private Conexao conexao = new Conexao();

    public boolean inserirUsuario() {
        try{
            Connection con = conexao.getConexao();
            PreparedStatement novoUsuario = con.prepareStatement("INSERT INTO usuarios(nome, email, senha, role_id) VALUES(?, ?, md5(?), ?); ");
            novoUsuario.setString(1, "Matheus");
            novoUsuario.setString(2, "matheus@gmail.com");
            novoUsuario.setString(3, "admin");
            novoUsuario.setInt(4, 1);
            int linhaAfetada = novoUsuario.executeUpdate();
            return linhaAfetada > 0;
        } catch (Exception erro){
            System.out.println("Erro ao inserir usuario: " + erro.getMessage());
            return false;
        }
    }

}
