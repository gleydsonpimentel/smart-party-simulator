
package br.com.novaroma.smartparty.estruturas;

import br.com.novaroma.smartparty.entities.Entity;

public class Pilha {

    private int topo;
    private Entity pilha[];

    public Pilha() {
        topo = -1;
        pilha = new Entity[50];
    }

    public Pilha(int length) {
        pilha = new Entity[length];
        topo = -1;
    }

    public void empilhar(Entity entity) {

        if (!pilhaCheia()) {
            getPilha()[getTopo() + 1] = entity;
            setTopo(getTopo() + 1);
        }
    }

    public void desempilhar() {

        if (!pilhaVazia()) {
            getPilha()[getTopo()] = null;
            setTopo(getTopo() - 1);
        }
    }

    public String verTopo() {

        String nomeTopo = "";

        if (!pilhaVazia()) {
            nomeTopo = getPilha()[getTopo()].getId();
        }

        return nomeTopo;
    }

    public String verPilha() {

        String texto = "";

        if (!pilhaVazia()) {
            for (int i = 0; i <= getTopo(); i++) {
                texto += getPilha()[i].getId() + " ";
            }
        }

        return texto;
    }

    private boolean pilhaCheia() {
        return getTopo() == getPilha().length;
    }

    private boolean pilhaVazia() {
        return getTopo() == -1;
    }
    
    public Entity search(String id) {
       
        Entity entityX = null;
        
        if (!pilhaVazia()) {
            for (int i = 0; i <= getTopo(); i++) {
                if (id.equals(getPilha()[i].getId())) {
                   entityX = getPilha()[i]; 
                }
            }
        }
        
        return entityX;
    }
    
    public void update(Entity entity) {
        
        if (!pilhaVazia()) {
            for (int i = 0; i <= getTopo(); i++) {
                if (entity.getId().equals(getPilha()[i].getId())) {
                    getPilha()[i] = entity; 
                }
            }
        }
    }
    
    public boolean contains(String id) {
        
        if(search(id) == null)
            return false;
        else
            return true;
    }
    
    public Entity retornarIndice(int indice) {
        return pilha[indice];
    }

    public int getTopo() {
        return topo;
    }

    public void setTopo(int topo) {
        this.topo = topo;
    }

    public Entity[] getPilha() {
        return pilha;
    }

    public void setPilha(Entity[] pilha) {
        this.pilha = pilha;
    }

    
}
