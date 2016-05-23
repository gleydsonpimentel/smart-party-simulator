/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.novaroma.smartpartysimulator.entities;

import java.io.Serializable;

/**
 *
 * @author Renato
 */
public abstract class Person extends Entity implements Serializable{
    
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
