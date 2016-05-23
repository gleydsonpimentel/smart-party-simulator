package br.novaroma.smartpartysimulator.entities.dao.estruturas;


import br.novaroma.smartpartysimulator.entities.dao.estruturas.No;


public class Pilha {

	private No obj[];
	private int topo;
	private int quant;
	
	public Pilha(int quant) {
		obj = new No[quant];
		this.quant=quant;
		topo=-1;
	}

	public void statusPilha(){
		
		System.out.println("Quantidade de posi��es ocupadas:" + (topo+1));
		System.out.println("Quantidade de posi��es livres:" + (quant-(topo+1)) + "\n");
		
	} 
	
	public void exibirPilha(){
		
		if(pilhaVazia()){
			
			System.out.println("Pilha Vazia");
			
		}else{
			String pilha = "";	
			
			for (int i = 0; i <= topo; i++) {

				pilha= pilha + obj[i]+"\n";
				
			}
			
			System.out.println(pilha);
		}
		
	}
	
	public void desempilhar(){
		
		if(pilhaVazia()){
			
			System.out.println("Pilha Vazia");
			
		}else{
			
			obj[topo]=null;
			
			topo--;
		}
	} 
	
	public void empilhar(No objc){
		
		if(pilhaVazia()){
			
			obj[0]=objc;
			topo++;
			
		}else if(pilhaCheia()){
			
			System.out.println("Pilha Cheia");
			
		}else{
			
			topo++;
			obj[topo]=objc;
		}
		
	}
	
	public boolean pilhaCheia(){
		
		return topo==quant-1;
	}
	
	public boolean pilhaVazia(){
		
		return topo ==-1;
	}
	
	public Object[] getObj() {
		return obj;
	}

	public void setObj(No[] obj) {
		this.obj = obj;
	}

	public int getTopo() {
		return topo;
	}

	public void setTopo(int topo) {
		this.topo = topo;
	}
	
	
}
