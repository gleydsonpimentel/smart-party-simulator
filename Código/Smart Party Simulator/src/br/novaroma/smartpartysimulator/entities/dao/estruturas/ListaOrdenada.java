package br.novaroma.smartpartysimulator.entities.dao.estruturas;


public class ListaOrdenada {


	private No first;
	private No last;
	static private int quantity;

	public ListaOrdenada() {

		first = null;
		last = null;
		quantity=0;
	}

	void inserir(No no){
		
		if(listaVazia()){
			
			setFirst(no);
			
		}else{
			No temp = first;
			int cont = 0;
			
			for (int i = 0; i < quantity; i++) {
				cont = temp.getP().toString().compareTo(no.getP().toString()); 
				
					
				if(cont<0){
					
					
					
				}else if(cont==0){
					no.setProx(temp.getProx());
					temp.setProx(no);
					
				}else{
					
					no.setProx(temp.getProx());
					temp.setProx(no);
										
					
				}
				
				temp = temp.getProx();
			}
			
		}
		
	}
	
	boolean buscarPessoaPorNome(String nome){
		boolean encontrado = false;
		
		if(listaVazia()){
			
		}else{
			
			No temp = first;
			
			while(temp!=null){
				
				if(temp.getP().toString().equals(nome)){
					
					encontrado=true;
					
				}
				
				temp=temp.getProx();
			}
			
		}
		
		return encontrado;
	}
	
	public void exibirPrimeiro(){
		if(listaVazia()){

			System.out.println("Lista Vazia");

		}else{

			System.out.println(first.getP().toString());

		}
	}

	int getQuantity(){

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

			int cont=0;
			No temp = first;
			No temp2= first.getProx();
			No temp3= temp2.getProx();

			do{

				if(cont+1 == position){

					temp.setProx(temp3);
					temp3.setAnt(temp);
					break;
				}

				temp=temp.getProx();
				temp2=temp2.getProx();
				temp3=temp3.getProx();
				cont++;

			}while(!(cont==quantity));

			quantity--;

		}
	}

	void removerNoComeco(){ 	

		if(listaVazia()){

			System.out.println("Lista Vazia");

		}else{

			first=first.getProx();
			first.setAnt(null);

		}

		quantity--;
	}

	public void removerNoFim(){


		if(listaVazia()){


			System.out.println("Lista Vazia");


		}else{

			No temp=last.getAnt();

			temp.setProx(null);

			setLast(temp);
		}

		quantity--;

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
		boolean vazia = false;

		if(first==null){

			vazia = true;

		}


		return vazia;
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
