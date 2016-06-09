package br.com.novaroma.smartparty.entities;

public class Manager extends Employee {

    private String nomeUsuario;
    private String senha;
    
    public Manager() {
    }

    public Manager(String name, String cpf, String email, long fone, int age,int anoContratacao) {
        
        super(name, cpf, email, fone, age,anoContratacao);
        
        this.nomeUsuario="admin";
        this.senha="admin";
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    
    
}
