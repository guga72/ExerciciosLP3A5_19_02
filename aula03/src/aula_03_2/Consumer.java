package aula_03_2;

public class Consumer implements Runnable{
	
	private Pilha pilha;
	
	public Consumer (Pilha pilha){ this.pilha = pilha;}
	
	
	@Override
	public void run() {
		while(true) {
			System.out.println(pilha.pop());	
		}
	}
}
