package aula_03_2;

import java.util.Random;

import aula_03_1.SharedObject;

public class Producer implements Runnable{
	
	private SharedObject shared;
	
	Producer (SharedObject shared){ this.shared = shared;}
	
	@Override
	public void run() {
		while(true) {
			System.out.println(Pilha.pop());
		}
	}
}
