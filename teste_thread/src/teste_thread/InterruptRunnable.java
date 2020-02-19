package teste_thread;

public class InterruptRunnable implements Runnable{
	
	public String texto;
	
	public int delay;
	
	public InterruptRunnable(String texto1, int delay1) {
		setDelay(delay1);
		setTexto(texto1);
	}

	@Override
	public void run() {
		int contador = 1;
		try {
			while(true) {
				System.out.println(texto + " " + contador);
				Thread.sleep(delay);
				contador ++;
			}
		} catch (InterruptedException e) {
			System.out.println("\n" + Thread.currentThread().getName() + " interrupted");
		}
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public int getDelay() {
		return delay;
	}

	public void setDelay(int delay) {
		this.delay = delay;
	}
	
	

}
