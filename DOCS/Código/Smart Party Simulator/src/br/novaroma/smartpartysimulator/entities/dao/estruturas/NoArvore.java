package br.novaroma.smartpartysimulator.entities.dao.estruturas;


public class NoArvore {

	private int valor;
	private NoArvore right;
	private NoArvore left;
	private int level;
	private int degree;
	private int altura;
	
	public NoArvore getRight() {
		return right;
	}

	public void setRight(NoArvore right) {
		this.right = right;
	}

	public NoArvore getLeft() {
		return left;
	}

	public void setLeft(NoArvore left) {
		this.left = left;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getDegree() {
		return degree;
	}

	public void setDegree(int degree) {
		this.degree = degree;
	}

	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}

	public NoArvore(int p) {

		this.valor = p;
		right = null;
		left = null;
	}

	public NoArvore getAnt() {
		return left;
	}

	public void setAnt(NoArvore ant) {
		this.left = ant;
	}

	public int getP() {
		return valor;
	}

	public void setP(int p) {
		this.valor = p;
	}


	
}
