package model;

public class Usuario extends Pessoa {
    private int id, role_id;
    private String senha;

    public Usuario(String nome, String email, int role_id, String senha) {
        super(nome, email);
        this.role_id = role_id;
        this.senha = senha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
