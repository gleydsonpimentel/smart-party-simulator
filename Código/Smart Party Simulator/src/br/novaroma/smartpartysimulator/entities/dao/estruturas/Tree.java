package br.novaroma.smartpartysimulator.entities.dao.estruturas;


public class Tree {

	private NoArvore raiz;
	
	public void Search(int valor){

		raiz= searchNo(raiz, valor);
		
	}
	
	private NoArvore searchNo(NoArvore no, int valor) {

		if(no == null){

			System.out.println("Valor: " + valor + " N�o encontrado");
			
		}
		else if(valor < no.getP()){
			
			no.setLeft(searchNo(no.getLeft(),valor));
			
		}else if(valor > no.getP()){

			no.setRight(searchNo(no.getRight(),valor));
			
		}else{

			System.out.println("Valor ja existe");
		
		}
		
		return no;
	}

		
	
/*
	public void inserirNo(int novoValor){
		
		raiz = inserir(raiz, novoValor);
		
	}
	
	private NoArvore inserir (NoArvore no, int novoNo){
		
		if(no == null){

			return new NoArvore(novoNo);
		}
		else if(novoNo < no.getP()){
			
			no = no.getLeft();
			
			inserir(no, novoNo);
		}else if(novoNo > no.getP()){
			
			no = no.getRight();
			inserir(no, novoNo);
		}else{

			System.out.println("Valor ja existe");
		
		}
		
		return no;
	}
*/
	public void imprimirArvore(){
        if(this.raiz == null)
            System.out.println("�rvore vazia");
        else
            imprimirArvore(this.raiz);
    }
    
    private void imprimirArvore(NoArvore node){
        if(node.getLeft() != null){
            imprimirArvore(node.getLeft());
        }
        if (node.getRight() != null){
            imprimirArvore(node.getRight());
        }
        System.out.println("N�: " + node.getP());
    }
	
    public void inserir(int valor){
        inserir(this.raiz, valor);
    }
    
    public void inserir(NoArvore node, int valor) {
        if(this.raiz == null){
            this.raiz = new NoArvore(valor);
        } else {
            if (valor < node.getP()) {
                if (node.getLeft() != null) { 
                    inserir(node.getLeft(), valor); 
                } else { 
                    //Se nodo esquerdo vazio insere o novo no aqui 
                    node.setLeft(new NoArvore(valor)); 
                } 
                //Verifica se o valor a ser inserido � maior que o no corrente da �rvore, se sim vai para subarvore direita 
            } else if (valor > node.getP()) { 
                //Se tiver elemento no no direito continua a busca 
                if (node.getRight() != null) { 
                    inserir(node.getRight(), valor); 
                } else {
                    //Se nodo direito vazio insere o novo no aqui 
                    node.setRight(new NoArvore(valor)); 
                } 
            }
        }
    }
    
    
}
