package aula_03_2;

public class Pilha {

	public static char alfabeto[] = {' ',' ',' ',' ',' ',' '};
	private int cursor = 0;
	
	public synchronized void push(char letra) {
		try {
			while(cursor == 6) {
				wait();
			}
			alfabeto[cursor] = letra;
			this.cursor ++;
			notifyAll();
		} catch (InterruptedException e) {
			
		}
	}
	
	public synchronized char pop() {
		try {
			while(cursor == 0) {
				wait();
			}
				char letra = alfabeto[alfabeto.length - 1];
				this.cursor --;
				notifyAll();
				return letra;
		}catch (InterruptedException e) {
			return 0;
		}
    }
}
