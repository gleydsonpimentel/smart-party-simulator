package br.com.novaroma.smartparty.entities;

public class Counter extends Employee {

    private String nomeUsuario;
    private String senha;
    
    public Counter() {
    }

    public Counter(String name, String cpf, String email, long fone, int age, int anoContratacao, String nomeUsuario, String senha) {
        super(name, cpf, email, fone, age, anoContratacao);
    
        this.nomeUsuario=nomeUsuario;
        this.senha=senha;
    
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
