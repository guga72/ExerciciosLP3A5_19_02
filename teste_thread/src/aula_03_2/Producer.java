package aula_03_2;

public class Producer implements Runnable{
	
	private Pilha pilha;
	
	private char alfabeto[] = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w'};
	
	Producer (Pilha pilha){ this.pilha = pilha;}
	
	@Override
	public void run() {
		
		for(char letra :alfabeto) {
			pilha.push(letra);
		}
	}
}
