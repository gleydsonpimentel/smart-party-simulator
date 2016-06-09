package br.com.novaroma.smartparty.entities;


public abstract class Person extends Entity {
    
    private String name;
    private String cpf;
    private String email;
    private long fone;
    private int age;
    
    public Person(){
        
    }
    
    public Person(String name, String cpf, String email, long fone, int age){
        this.name = name;
        this.cpf = cpf;
        this.email = email;
        this.fone = fone;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getFone() {
        return fone;
    }

    public void setFone(long fone) {
        this.fone = fone;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    
}
