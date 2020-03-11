package aula_03_1;

public class ProducerConsumerExample {
	
	public static void main(String[] args) {
		SharedObject o = new SharedObject();
		String[] names = {"C1", "C2", "P1", "P2"};
		Thread[] threads = { new Thread(new Consumer(o)), new Thread(new Consumer(o)),
							 new Thread(new Producer(o)), new Thread(new Producer(o))};
		for(int i = 0; i < threads.length; i++) {
			threads[i].setName(names[i]);
			threads[i].start();
		}
		
		try {
			for(Thread t: threads) {
				t.join(1500);
				if(t.isAlive()) { t.interrupt(); }
			}
		}catch (InterruptedException e) {
			System.out.println("Main DONE");
		}
	}
}
