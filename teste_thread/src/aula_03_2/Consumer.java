package aula_03_2;

import aula_03_1.SharedObject;

public class Consumer implements Runnable{
	
	private SharedObject shared;
	
	Consumer(Pilha pilha){ 
		for(char letra : alfabeto) {
			pilha.push(letra);
		}
	}
	
	public static char alfabeto[] = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w'};
	
	@Override
	public void run() {
		Pilha pilha = new Pilha();
		
		System.out.println(Thread.currentThread().getName()+ ": Consumer DONE.");
	}
}
