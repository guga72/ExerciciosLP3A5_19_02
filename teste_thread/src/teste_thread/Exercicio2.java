package teste_thread;

public class Exercicio2 {

	public static void main(String[] args) {
		Runnable runnable = new InterruptRunnable("Texto", 200);
		Runnable runnable1 = new InterruptRunnable("Teste", 300);
		Runnable runnable2 = new InterruptRunnable("Alguma coisa", 500);
		
		Thread t1 = new Thread(runnable);
		Thread t2 = new Thread(runnable1);
		Thread t3 = new Thread(runnable2);
		
		t1.start();
		t2.start();
		t3.start();
		try {
		  Thread.sleep(5000);
		  t1.interrupt();
		  Thread.sleep(5000);
		  t2.interrupt();
		  Thread.sleep(5000);
		  t3.interrupt();
		} catch (InterruptedException e) {}
	}

}
