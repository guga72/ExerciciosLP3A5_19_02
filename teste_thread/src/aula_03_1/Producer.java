package aula_03_1;

import java.util.Random;

public class Producer implements Runnable{

	private SharedObject shared;
	private static final int TENTATIVAS = 3;
	
	Producer (SharedObject shared){ this.shared = shared;}
	
	@Override
	public void run() {
		for (int i = 0; i < TENTATIVAS; i++) {
			if(!shared.set(new Random().nextInt(1000)))
				break;
		}
		System.out.println(Thread.currentThread().getName()+ ": Producer DONE.");
	}
	
}
