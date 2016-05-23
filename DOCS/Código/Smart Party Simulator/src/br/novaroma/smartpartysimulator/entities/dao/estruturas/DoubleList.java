package br.novaroma.smartpartysimulator.entities.dao.estruturas;


public class DoubleList {

	private No first;
	private No last;
	static private int quantity;

	public DoubleList() {

		first = null;
		last = null;
		quantity=0;
	}



	public void exibirPrimeiro(){
		if(listaVazia()){

			System.out.println("Lista Vazia");

		}else{

			System.out.println(first.getP().toString());

		}
	}

	public int getQuantity(){

		return quantity;
	}

	public void removerQualquerPosicao(int position){

		if(listaVazia()){

			System.out.println("Lista Vazia");

		}else if(position==0){

			removerNoComeco();

		}else if(position+1 == quantity){

			removerNoFim();	

		}else if(position+1 > quantity  || position<0){

			System.out.println("N�o existe essa posi��o na lista");

		}else{
			No temp = first;
			No temp2 = temp.getProx();

			for (int i = 1; i < quantity; i++) {
				if (i == position+1) {
					temp.setProx(temp2.getProx());
					temp2.getProx().setAnt(temp);
				}
				temp = temp.getProx();
				temp2 = temp2.getProx();
			}


			System.out.println("Pessoa removida");
			quantity--;
		}
	}

	public void removerNoComeco(){ 	

		if(listaVazia()){

			System.out.println("Lista Vazia");

		}else if(quantity==1){

			setFirst(null);
			setLast(null);

		}else{

			first=first.getProx();
			first.setAnt(null);

		}

		quantity--;
	}

	public void removerNoFim(){


		if(listaVazia()){


			System.out.println("Lista Vazia");

		}else if(quantity==1){

			setFirst(null);
			setLast(null);
		}else{

			No temp=last.getAnt();

			temp.setProx(null);

			setLast(temp);
		}

		quantity--;

	}

	public void inserirNoFim(No newCrux){

		if(listaVazia()){

			setFirst(newCrux);
			setLast(newCrux);

		}else{

			last.setProx(newCrux);
			newCrux.setAnt(last);
			last=newCrux;
		}

		quantity++;

	}

	public void inserirQualquerPosicao(No newNo, int position){

		if(listaVazia()){

			setFirst(newNo);
			setLast(newNo);

		}else if(position==0){

			inserirNoComeco(newNo);

		}else if(position==quantity){

			inserirNoFim(newNo);

		}else if(position<0 || position+1 > quantity){


			System.out.println("posi��o inv�lida");


		}else{

			No temp = first;

			for (int i = 1; i < quantity; i++) {
				if (i == position+1) {
					newNo.setAnt(temp);
					newNo.setProx(temp.getProx());
					temp.setProx(newNo);
				}
				temp = temp.getProx();
			}
			quantity++;
			
		}

		
	}

	public void inserirNoComeco(No newNo){

		if(listaVazia()){

			setFirst(newNo);
			setLast(newNo);

		}else{

			newNo.setProx(first);
			first.setAnt(newNo);
			first=newNo;
		}
		quantity++;

	}

	public void exibirListaPrimeiro(){

		if(listaVazia()){

			System.out.println("Lista vazia");

		}else{

			No temp=first;

			while(temp!=null){

				System.out.println(temp.getP().toString());
				temp=temp.getProx();

			}

		}


	}

	public void exibirListaUltimo(){

		if(listaVazia()){

			System.out.println("Lista vazia");

		}else{

			No temp=last;

			while(temp!=null){

				System.out.println(temp.getP().toString());
				temp=temp.getAnt();

			}

		}

	}

	public boolean listaVazia() {
				
		return first ==null;
	}

	private void setFirst(No first) {
		this.first = first;
	}

	private void setLast(No last) {
		this.last = last;
	}

	public void exibirQuantidade(){

		System.out.println("Quantidade: "+ quantity);
	}

}
