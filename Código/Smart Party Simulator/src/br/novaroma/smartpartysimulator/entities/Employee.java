/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.novaroma.smartpartysimulator.entities;

/**
 *
 * @author Renato
 */
public class Employee extends Person{

    private long id;
    
    public Employee(){
        super();  
    }
    
    public Employee(String name, String cpf, String email, long fone, int age){
        super(name, cpf, email, fone, age);
    }
    
   
    @Override
    public String getId() {
        return id+"";
    }

 
    
}
