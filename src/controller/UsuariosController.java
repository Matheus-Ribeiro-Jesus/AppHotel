package controller;

import dao.UsuariosDAO;
import model.Usuario;

public class UsuariosController {
    private final UsuariosDAO usuariosDAO;

    /*Construtor para inicializar objeto UsuariosController()
    * Ao inicializa-lo o construtor de UsuariosDAO() sera exeuctado oque signfica que a camada de Controle estara verirciando se os parametros necessarios foram informados para que sejam enviados as requisições
    * (package DAO - Data Acess Object) */

    public UsuariosController() {
        this.usuariosDAO = new UsuariosDAO();
    }
    /* Metodo para verificar se os parametros necessarios para autenticação estao presente ou seja nao podem ser vazios ou nulos
    * se estiverem presentes um objeto de usuario é inicializado como uma instancia */


    public boolean verificarCredenciais(String email, String senha) {
        if (email == null || email.isEmpty() || senha == null || senha.isEmpty()) {
            return false;
        }
        Usuario usuario = new Usuario("", email, 0, senha);
        return usuariosDAO.autenticarUsuario(usuario);
    }
}
