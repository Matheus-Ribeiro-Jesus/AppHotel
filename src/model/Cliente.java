package model;

public class Cliente extends Pessoa {

    //Declaração de uma variavel propria da classe Cliente
    private int id;
    private String cpf, telefone;

    public Cliente(String nome, String email, String cpf, String telefone) {
        super(nome, email);
        this.cpf = cpf;
        this.telefone = telefone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
