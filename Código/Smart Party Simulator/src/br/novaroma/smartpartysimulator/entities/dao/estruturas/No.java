package br.novaroma.smartpartysimulator.entities.dao.estruturas;


public class No {

	private Object p;
	private No prox;

	private No ant;

	public No(Object p) {

		this.p = p;
		prox = null;
		ant = null;
	}

	public No getAnt() {
		return ant;
	}

	public void setAnt(No ant) {
		this.ant = ant;
	}

	public Object getP() {
		return p;
	}

	public void setP(Pessoa p) {
		this.p = p;
	}

	public No getProx() {
		return prox;
	}

	public void setProx(No prox) {
		this.prox = prox;
	}

}
