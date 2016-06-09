package br.com.novaroma.smartparty.estruturas;

import br.com.novaroma.smartparty.entities.Entity;
import br.com.novaroma.smartparty.entities.Person;


public class List {

    private No first;
    private No last;
    private int count;
    
    public void addFirst(Entity entity) {

        No novoNo = new No(first, null, entity);
       
        if (!isFirst()) {
            first.setAnt(novoNo);
        }
        
        first = novoNo;

        if (isFirst()) 
            last = first;
        
        count++;
    }
    
    public void addLast(Entity entity) {
        
        if (isFirst()) {
            addFirst(entity);
        } else {
            No novoNo = new No(null, last, entity);
            last.setProx(novoNo);
            last = novoNo;
            
            count++;
        }
    }
    
    public void addBetween(Entity entity, int position) {
        
        if (position == 1) {
            addFirst(entity);
        } else if (position == count + 1) {
            addLast(entity);
        } else {
            No previous = returnLink(position - 1);
            No next = previous.getProx();
            No novoNo = new No(next, previous, entity);
            
            next.setAnt(novoNo);
            previous.setProx(novoNo);
            count++;
        }
    }
    
    public void removeFirst() {

        if (isFirst()) 
            throw new IllegalArgumentException("Nao ha itens para serem excluidos!");
        

        if (count == 1) {
            first = last = null;
        }
        else {
        first = first.getProx();
        first.setAnt(null);
        }
        
        count--;
    }
    
    public void removeLast() {
        
        if (isFirst()) {
            throw new IllegalArgumentException("Nao ha itens para serem excluidos!");
        }
        
        if (count == 1) {
            removeFirst();
        } else {
            last = last.getAnt();
            last.setProx(null);
            count--;
        }
    }
    
    public void removeBetween(int position) {
        
        if (position == 0) {
            System.out.println("Entidade nao existente!");
        } else if (position == 1) {
            removeFirst();
        } else if (position == count) {
            removeLast();
        } else {
            No ant = returnLink(position - 1);
            No prox = returnLink(position + 1);
            
            ant.setProx(prox);
            prox.setAnt(ant);
            count--;
        }
    }
    
    public String showList() {

        No temp = first;
        String names = "";

        while (temp != null) {
            
            if (temp.getEntity() instanceof Person) {
                Person person = (Person)temp.getEntity();
                
                names += person.getName() + " ";
            }
            else{
            names += temp.getEntity().getId() + " ";
            }
            
            temp = temp.getProx();
        }

        return names;
    }
    
    public String showReverseList() {

        No temp = last;
        String names = "";
        
        while (temp != null) {
            if (temp.getEntity() instanceof Person) {
                Person person = (Person)temp.getEntity();
                
                names += person.getName() + " ";
            }
            else{
            names += temp.getEntity().getId() + " ";
            }
            
            temp = temp.getAnt();
        }

        return names;
    }
    
    public int showQuantity() {
        return count;
    }
    
    private boolean isFirst() {
        return count == 0;
    }
    
    private boolean verifyPosition(int position) {
        return position > 0 && position <= count + 1;
    }
    
    public No returnLink(int position) {
        
        if (!verifyPosition(position)) {
            throw new IllegalArgumentException("Posicao invalida!");
        }
        
        No temp = first;
        
        for (int i = 0; i < position - 1; i++) {
            temp = temp.getProx();
        }
        return temp;
    }
    
    public boolean contains(String id) {
        
        No temp = first;
        boolean boo = false;
        
        while (temp != null) {            
            if (temp.getEntity().getId().equalsIgnoreCase(id)) {
                boo = true;
            }
            
            temp = temp.getProx();
        }
        
        return boo;
    }
    
    public int searchPosition(String id) { //SE RETORNAR 0, NAO EXISTE NA LISTA!
        
        No temp = first;
        int position = 0;
        int cont = 0;

        if (contains(id)) {
            while (temp != null) {      
                if (temp.getEntity().getId().equalsIgnoreCase(id)) {
                    position = cont + 1;
                }
                cont++;
                
                temp = temp.getProx();
                
            }
        }
       
        return position;
    }
    
    public void update(Entity entity) {
        
        No temp = first;
        
        while (temp != null) {
            if (entity.getId().equalsIgnoreCase(temp.getEntity().getId())) {
                temp.setEntity(entity);
            }
           
            temp = temp.getProx();
        }
    }
    
    public No getFirst() {
        return first;
    }
     
}
