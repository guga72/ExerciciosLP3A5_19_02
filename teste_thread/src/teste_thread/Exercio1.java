package teste_thread;

public class Exercio1{

	public static void main(String[] args) {
		Runnable runnable = new InterruptRunnable("Texto", 200);
		Thread t1 = new Thread(runnable);
		t1.start();
		try {
		  Thread.sleep(2000);
		} catch (InterruptedException e) {}
		t1.interrupt();
	}

}
