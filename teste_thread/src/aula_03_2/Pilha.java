package aula_03_2;

public class Pilha {

	public static char alfabeto[];
	static int cursor = 0;
	
	public synchronized void push(char letra) {
		try {
			if(alfabeto.length <= 6) {
				alfabeto[cursor] = letra;
			}
			else {
			  wait();	
			}
		} catch (InterruptedException e) {
			
		}
	}
	
	public synchronized char pop() {
		try {
			if(alfabeto.length >= 1) {
				wait();
			}
			else {
				char letra = alfabeto[alfabeto.length];
				cursor --;
				return letra;	
			}
		}catch (InterruptedException e) {
		}
		return 0;
    }
}
