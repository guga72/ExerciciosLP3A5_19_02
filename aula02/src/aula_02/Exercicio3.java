package aula_02;

import java.util.ArrayList;

public class Exercicio3 {

	static ArrayList<Double> pares = new ArrayList<Double>();

	static ArrayList<Double> impares = new ArrayList<Double>();
	
	public static void pegarValores() {
		for(int cont = 1; cont<= 1000; cont++) {
			if(cont >= 1 && cont < 100) {
				if(cont%2 != 0) {
					impares.add(Math.sqrt(cont));
				}
			}
			if(cont%2 == 0) {
				pares.add(Math.cbrt(cont));
			}
		}
	}
	
	public static void main(String Args[]) {
		pegarValores();
		try {
			for(int cont = 0; cont < pares.size(); cont++) {
				System.out.println(pares.get(cont));
				Thread.sleep(50);
			}
			for(int cont = 0; cont < impares.size(); cont++) {
				System.out.println(impares.get(cont));
				Thread.sleep(50);
			}
		} catch (InterruptedException e) {}
	}

}
