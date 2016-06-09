package br.com.novaroma.smartparty.estruturas;

import br.com.novaroma.smartparty.entities.Entity;


public class NoDuplo {

	private Entity entity;
	private NoDuplo prox;
	private NoDuplo ant;

	public NoDuplo() {

	}

        public NoDuplo(Entity entity){
            this.entity=entity;
        }
        
        public NoDuplo(NoDuplo prox, NoDuplo ant, Entity entity) {
        this.prox = prox;
        this.ant = ant;
        this.entity = entity;
    }
        
	public NoDuplo getAnt() {
		return ant;
	}

	public void setAnt(NoDuplo ant) {
		this.ant = ant;
	}

	public Entity getEntity() {
		return entity;
	}

	public void setP(Entity entity) {
		this.entity = entity;
	}

	public NoDuplo getProx() {
		return prox;
	}

	public void setProx(NoDuplo prox) {
		this.prox = prox;
	}

}