package dao;
import utils.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UsuariosDAO {

    //Objeto para instanciar classe Conexao para requisitrar acesso ao DB

    private Conexao conexao = new Conexao();

    public boolean inserirUsuario() {
        try{
            Connection con = conexao.getConexao();
            PreparedStatement novoUsuario = con.prepareStatement("INSERT INTO usuarios(nome, email, senha, role_id) VALUES(?, ?, md5(?), ?); ");
            novoUsuario.setString(1, "Lucas");
            novoUsuario.setString(2, "Lucas@gmail.com");
            novoUsuario.setString(3, "admin");
            novoUsuario.setInt(4, 1);
            int linhaAfetada = novoUsuario.executeUpdate();
            return linhaAfetada > 0;
        } catch (Exception erro){
            System.out.println("Erro ao inserir usuario: " + erro.getMessage());
            return false;
        }
    }
    public boolean removeUsuario() {
        try{
            Connection con = conexao.getConexao();
            PreparedStatement RemoverUsuario = con.prepareStatement("DELETE FROM usuarios WHERE id = ?;");
            RemoverUsuario.setInt(1,1);
            int linhaAfetada = RemoverUsuario.executeUpdate();
            con.close();
            return linhaAfetada > 0;
        }catch (Exception e){
            System.out.println("Erro ao remover role! " + e.getMessage());
            return false;
        }
    }

    public boolean atualizarUsuarios(){
        try{
            Connection con = conexao.getConexao();
            PreparedStatement atualizarUsuarios = con.prepareStatement("UPDATE usuarios SET nome = ?, email = ?, senha = md5(?), role_id = ? WHERE id = ?;");
            atualizarUsuarios.setString(1, "Matheus Ribeiro");
            atualizarUsuarios.setString(1, "matheusribeiro2@gmail.com");
            atualizarUsuarios.setString(1, "1234");
            atualizarUsuarios.setInt(1, 2);
            int linhaAfetada = atualizarUsuarios.executeUpdate();
            con.close();
            return linhaAfetada > 0;
        }catch (Exception erro){
            System.out.println("Erro ao atualizar usuarios! " + erro.getMessage());
            return false;
        }
    }

    public void pesquisarUsuarios(){
        try{
            Connection con = conexao.getConexao();
            PreparedStatement buscarusuario = con.prepareStatement("SELECT nome, email, role_id FROM usuarios WHERE id = ?");
            buscarusuario.setString(1, "Matheus");
            buscarusuario.setString(1, "matheus@gmail.com");
            buscarusuario.setInt(1, 1);
            ResultSet resultado = buscarusuario.executeQuery();
            while(resultado.next()){
                String nome = resultado.getString("nome");
                String email = resultado.getString("email");
                String role_id = resultado.getString("role_id");
                System.out.println("Nome: " + nome + " Email: " + email + " Role: " + role_id);
            }
            con.close();
        }catch (Exception error){
            System.out.println("Erro ao pesquisar usuarios! " + error.getMessage());
        }
    }
}
