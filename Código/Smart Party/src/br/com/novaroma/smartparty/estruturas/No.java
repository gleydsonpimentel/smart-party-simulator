package br.com.novaroma.smartparty.estruturas;

import br.com.novaroma.smartparty.entities.Entity;


public class No {

    private No prox;
    private No ant;
    private Entity entity;

    public No() {

    }

    public No(Entity entity) {
        this.entity = entity;
    }

    public No(No next, No previous, Entity entity) {
        this.prox = next;
        this.ant = previous;
        this.entity = entity;
    }

    public No getProx() {
        return prox;
    }

    public void setProx(No prox) {
        this.prox = prox;
    }

    public No getAnt() {
        return ant;
    }

    public void setAnt(No ant) {
        this.ant = ant;
    }

    public Entity getEntity() {
        return entity;
    }

    public void setEntity(Entity entity) {
        this.entity = entity;
    }
    
}
