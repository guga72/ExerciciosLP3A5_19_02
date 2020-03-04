package aula_03_1;

public class SharedObject {

	private volatile int value = -1;
	
	public boolean isSet() { return value != -1; }
	
	public synchronized boolean set(int v) {
		try {
			while(isSet()) {
				wait();
			}
			value = v;
			System.out.println(Thread.currentThread().getName() + ": Produced: " + value);
			notify();
			return true;
		}catch (InterruptedException e) { return false; }
	}
	
	public synchronized boolean reset() {
		try {
			while(!isSet()) {
				wait();
			}
			System.out.println(Thread.currentThread().getName() + ": Consumed: " + value);
			value = -1;
			notify();
			return true;
		} catch (InterruptedException e) {
			return false;
		}
	}
}
