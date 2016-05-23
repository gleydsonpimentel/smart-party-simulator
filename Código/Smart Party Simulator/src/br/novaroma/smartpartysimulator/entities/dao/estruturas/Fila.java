package br.novaroma.smartpartysimulator.entities.dao.estruturas;


public class Fila {

	private No obj[];
	private int inicio;
	private int fim;
	private int quantidade;
	private int tamanho;

	public Fila(int tamanho){
		obj= new No[tamanho];
		inicio=fim=quantidade=0;
		this.tamanho=tamanho;
	}

	public int tamanhoFila(){
		int quant=0;

		if(!filaVazia()){

			quant = quantidade;
		}

		return quant;	
	}

	public No primeiroFila(){
		No temp=null;
		if(filaVazia()){

			System.out.println("Fila Vazia");

		}else{

			temp=obj[inicio];	

		}
		return temp;
	}

	public void exibirFila(){
		if(filaVazia()){

			System.out.println("Fila Vazia");

		}else{
			String a ="";
			int j=inicio; 

			for (int i = 0; i <quantidade ; i++) {

				a+=obj[j].getP() + " ";

				j++;

				if(j>=tamanho){

					j=0;

				}
			}
			System.out.println(a);

		}

	}

	public No desenfileirar(){
		No temp = null;

		if(filaVazia()){

			System.out.println("Fila Vazia");

		}else{

			temp = obj[inicio];
			obj[inicio] = null;

			quantidade--;
			inicio++;

			circularInicio();

			//System.out.println("Remove o: " + temp.toString());

		}
		return temp;
	}

	public void enfileirar(No elemento){

		if(!filaCheia()){

			obj[fim]=elemento;

			fim++;
			quantidade++;

			circularFim();

		}

	}

	private void circularInicio(){
		if(inicio==tamanho){

			inicio=0;
		}

	}

	private void circularFim() {
		if(fim==tamanho){

			fim=0;
		}

	}

	public boolean filaCheia(){
		return quantidade==tamanho;
	}

	public boolean filaVazia(){
		return quantidade==0;
	}

	public Object[] getObj() {
		return obj;
	}

	public void setObj(No[] obj) {
		this.obj = obj;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}



}
