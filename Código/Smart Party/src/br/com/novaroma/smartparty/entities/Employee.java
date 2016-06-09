package br.com.novaroma.smartparty.entities;

public class Employee extends Person{

    private long id;
    private int anoContratacao;
    
    public Employee(){
        super();  
    }
    
    public Employee(String name, String cpf, String email, long fone, int age, int anoContratacao){
        super(name, cpf, email, fone, age);
    
        this.anoContratacao=anoContratacao;
    }

    public int getAnoContratacao() {
        return anoContratacao;
    }

    public void setAnoContratacao(int anoContratacao) {
        this.anoContratacao = anoContratacao;
    }
   
    @Override
    public String getId() {
        return id+"";
    }

}
