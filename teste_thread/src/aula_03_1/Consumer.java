package aula_03_1;

import java.util.Random;

public class Consumer implements Runnable{

	private SharedObject shared;
	private static final int TENTATIVAS = 3;
	
	Consumer(SharedObject shared){ this.shared = shared;}
	
	@Override
	public void run() {
		for (int i = 0; i < TENTATIVAS; i++) {
			if(!shared.set(new Random().nextInt(1000)))
				break;
		}
		System.out.println(Thread.currentThread().getName()+ ": Consumer DONE.");
	}
  
}
